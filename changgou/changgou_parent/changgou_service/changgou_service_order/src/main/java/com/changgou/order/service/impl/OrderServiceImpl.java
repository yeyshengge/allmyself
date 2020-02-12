package com.changgou.order.service.impl;


import com.alibaba.fastjson.JSON;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.order.config.RabbitMQConfig;
import com.changgou.order.dao.*;
import com.changgou.order.pojo.*;
import com.changgou.order.service.CartService;
import com.changgou.order.service.OrderService;
import com.changgou.pay.feign.PayFeign;
import com.changgou.user.feign.UserFeign;
import com.changgou.utils.IdWorker;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {


    private static final String CART;

    static {
        CART = "cart_";
    }

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderLogMapper orderLogMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private OrderConfigMapper orderConfigMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SkuFeign skuFeign;

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private PayFeign payFeign;


    /**
     * 查询全部列表
     *
     * @return
     */
    @Override
    public List<Order> findAll() {
        return orderMapper.selectAll();
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public Order findById(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }


    /**
     * 增加订单
     *
     * @param order
     */
    @Override
    //@GlobalTransactional(name = "order_add")
    public String add(Order order) {

        Map map = cartService.list(order.getUsername());
        //1,获取所有购物项
        List<OrderItem> orderItemList = (List<OrderItem>) map.get("orderItemList");
        Integer totalNum = (Integer) map.get("totalNum");
        Integer totalMoney = (Integer) map.get("totalMoney");
        //2,填充数据
        order.setTotalNum(totalNum);
        order.setTotalMoney(totalMoney);
        order.setPayMoney(totalMoney);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setBuyerRate("0"); //0：未评价  1：已评价
        order.setSourceType("1"); //1:WEB
        order.setOrderStatus("0"); //0:未完成,1:已完成，2：已退货
        order.setPayStatus("0"); //0:未支付，1：已支付，2：支付失败
        order.setConsignStatus("0"); //0:未发货，1：已发货，2：已收货
        order.setId(idWorker.nextId() + "");

        //3,报存订单信息
        //orderMapper.insertSelective(order);
        orderMapper.insertSelective(order);
        //orderRepository.save(order);


        //4,设置订单项信息
        for (OrderItem orderItem : orderItemList) {
            orderItem.setId(idWorker.nextId() + "");
            orderItem.setIsReturn("0");  //0:代表没退货 ，1:代表退货
            orderItem.setOrderId(order.getId());  //设置订单项所处订单id
            //5,保存订单项信息
            orderItemMapper.insertSelective(orderItem);
        }
        //4.1扣减库存跟增加销量
        skuFeign.decrCount(order.getUsername());
        //4.2增加用户加积分
        //userFeign.addPoints(order.getUsername(), order.getTotalMoney());
        //4.3向task表中插入数据
        Task task = new Task();
        task.setCreateTime(new Date());
        task.setUpdateTime(new Date());
        task.setMqExchange(RabbitMQConfig.EX_BUYING_ADDPOINTUSER);
        task.setMqRoutingkey(RabbitMQConfig.CG_BUYING_ADDPOINT_KEY);

        Map dataMap = new HashMap();
        dataMap.put("username", order.getUsername());
        dataMap.put("orderId", order.getId());
        dataMap.put("point", order.getTotalMoney());
        task.setRequestBody(JSON.toJSONString(dataMap));
        taskMapper.insertSelective(task);


        //5,清除Redis缓存购物车数据
        redisTemplate.delete(CART + order.getUsername());

        //向延迟队列（10s）发送订单id,用来判断订单到期是否支付
        rabbitTemplate.convertAndSend("", "queue.ordercreate", order.getId());
        return order.getId();

    }


    /**
     * 修改
     *
     * @param order
     */
    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKey(order);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(String id) {
        orderMapper.deleteByPrimaryKey(id);
    }


    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Order> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return orderMapper.selectByExample(example);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Order> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        return (Page<Order>) orderMapper.selectAll();
    }

    /**
     * 条件+分页查询
     *
     * @param searchMap 查询条件
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @Override
    public Page<Order> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        return (Page<Order>) orderMapper.selectByExample(example);
    }

    /**
     * 支付成功修改订单数据
     *
     * @param orderId
     * @param transactionId
     */
    @Override
    public void updateOrderStatus(String orderId, String transactionId) {

        //查询是否存在订单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        //订单不为null并且是未支付的
        if (order != null && "0".equals(order.getPayStatus())) {
            order.setPayStatus("1");
            order.setOrderStatus("1");
            order.setUpdateTime(new Date());
            order.setPayTime(new Date());
            //封装微信返回的支付流水号
            order.setTransactionId(transactionId);
            orderMapper.updateByPrimaryKeySelective(order);

            //记录订单变动日志

            OrderLog orderLog = new OrderLog();
            orderLog.setId(idWorker.nextId() + "");
            orderLog.setOperater("system");
            orderLog.setOperateTime(new Date());
            orderLog.setOrderStatus("1");
            orderLog.setPayStatus("1");
            orderLog.setOrderId(orderId);
            orderLog.setRemarks("微信支付流水号:" + transactionId);

            orderLogMapper.insertSelective(orderLog);
        }
    }

    /**
     * 关闭订单业务
     *
     * @param orderId
     */
    @Override
    public void closeOrder(String orderId) {
        //根据id查询订单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            throw new RuntimeException("订单不存在");
        }
        //如果已支付就不管
        if (!"0".equals(order.getPayStatus())) {
            return;
        }
        //查询微信订单
        Map queryMap = (Map) payFeign.queryOrder(orderId).getData();
        //判断是否已支付,如果已支付就补偿（修改支付状态）
        if ("SUCCESS".equals(queryMap.get("trade_state"))) {
            //其实就是修改订单信息，把未支付改成支付，还有其他字段
            this.updateOrderStatus(orderId, (String) queryMap.get("transaction_id"));
        }
        //判断是否未支付
        if ("NOTPAY".equals(queryMap.get("trade_state"))) {
            System.out.println("关闭订单业务开启！ : " + orderId);
            order.setCloseTime(new Date());//关闭时间
            order.setOrderStatus("4");//关闭状态
            orderMapper.updateByPrimaryKeySelective(order);//更新

            //记录订单变动日志
            OrderLog orderLog = new OrderLog();
            orderLog.setId(idWorker.nextId() + "");
            orderLog.setOperater("system");// 系统
            orderLog.setOperateTime(new Date());//当前日期
            orderLog.setOrderStatus("4");  //4代表已关闭
            orderLog.setOrderId(order.getId());
            orderLogMapper.insertSelective(orderLog);

            //回滚库存跟销量
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            List<OrderItem> orderItemList = orderItemMapper.select(orderItem);
            for (OrderItem item : orderItemList) {
                //遍历回滚数据，应为订单包含很多订单项
                skuFeign.resumeStockNum(item.getSkuId(), item.getNum());
            }

            //关闭订单
            payFeign.closeOrder(orderId);
        }

    }

    /**
     * 批量设置订单物流
     *
     * @param orderList
     */
    @Override
    @Transactional
    public void batchSend(List<Order> orderList) {

        //判断订单是否有误
        for (Order order : orderList) {
            if (order.getId() == null) {
                throw new RuntimeException("订单不存在");
            }
            if (order.getShippingCode() == null || order.getShippingName() == null) {
                throw new RuntimeException("请选择快递公司和填写快递单号");
            }
        }

        //判断订单有物流信息但是未支付
        for (Order order : orderList) {
            Order order1 = orderMapper.selectByPrimaryKey(order.getId());
            if (!"0".equals(order1.getConsignStatus()) || "1".equals(order1.getPayStatus())) {
                throw new RuntimeException("订单异常");
            }
        }
        //进行更新操作，设置物流信息
        for (Order order : orderList) {
            order.setConsignStatus("1");  //设置已发货
            order.setConsignTime(new Date());
            order.setUpdateTime(new Date());
            order.setOrderStatus("2");  //设置订单已发货
            orderMapper.updateByPrimaryKeySelective(order);

            //记录订单历史操作
            OrderLog orderLog = new OrderLog();
            orderLog.setId(idWorker.nextId() + "");
            orderLog.setOrderId(order.getId());
            orderLog.setPayStatus("1");
            orderLog.setOperater("admin");
            orderLog.setOperateTime(new Date());
            orderLog.setOrderStatus("2"); //已完成
            orderLog.setConsignStatus("1");//发状态（0未发货 1已发货）

            orderLogMapper.insertSelective(orderLog);
        }

    }

    /**
     * 手动确定订单
     *
     * @param orderId
     * @param operator
     */
    @Override
    @Transactional
    public void confirmTask(String orderId, String operator) {

        Order order = orderMapper.selectByPrimaryKey(orderId);

        if (order == null) {
            throw new RuntimeException("订单不存在");
        }
        //订单未发货
        if (!"1".equals(order.getConsignStatus())) {
            throw new RuntimeException("订单未发货");
        }
        //手动收货
        order.setUpdateTime(new Date());
        order.setConsignStatus("2");  //已送达
        order.setOrderStatus("3"); //已完成
        order.setEndTime(new Date()); //设置订单关闭时间

        orderMapper.updateByPrimaryKeySelective(order);

        //日志记录
        OrderLog orderLog = new OrderLog();
        orderLog.setId(idWorker.nextId() + "");
        orderLog.setOrderId(order.getId());
        orderLog.setPayStatus("1");
        orderLog.setOperater(operator);
        orderLog.setOperateTime(new Date());
        orderLog.setOrderStatus("3"); //已完成
        orderLog.setConsignStatus("2");//发状态（0未发货 1已发货）

        orderLogMapper.insertSelective(orderLog);

    }

    /**
     * 自动收货
     * 在数据库获取订单自动收货时间，然后用当前时间减去自动收货时间，然后查询订单发货时间<这个时间的订单，且是已发货的
     */
    @Override
    public void orderTack() {

        OrderConfig orderConfig = orderConfigMapper.selectByPrimaryKey("1");

        //获取现在时间
        LocalDate localDate = LocalDate.now();
        //减去自动收货时间
        LocalDate data = localDate.plusDays(-orderConfig.getTakeTimeout());


        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLessThan("consignTime", data);
        criteria.andEqualTo("orderStatus", "2");
        List<Order> orders = orderMapper.selectByExample(example);

        //调用手动收货
        for (Order order : orders) {
            this.confirmTask(order.getId(), "system");
        }

    }

    /**
     * 构建查询对象
     *
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            // 订单id
            if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
                criteria.andEqualTo("id", searchMap.get("id"));
            }
            // 支付类型，1、在线支付、0 货到付款
            if (searchMap.get("payType") != null && !"".equals(searchMap.get("payType"))) {
                criteria.andEqualTo("payType", searchMap.get("payType"));
            }
            // 物流名称
            if (searchMap.get("shippingName") != null && !"".equals(searchMap.get("shippingName"))) {
                criteria.andLike("shippingName", "%" + searchMap.get("shippingName") + "%");
            }
            // 物流单号
            if (searchMap.get("shippingCode") != null && !"".equals(searchMap.get("shippingCode"))) {
                criteria.andLike("shippingCode", "%" + searchMap.get("shippingCode") + "%");
            }
            // 用户名称
            if (searchMap.get("username") != null && !"".equals(searchMap.get("username"))) {
                criteria.andLike("username", "%" + searchMap.get("username") + "%");
            }
            // 买家留言
            if (searchMap.get("buyerMessage") != null && !"".equals(searchMap.get("buyerMessage"))) {
                criteria.andLike("buyerMessage", "%" + searchMap.get("buyerMessage") + "%");
            }
            // 是否评价
            if (searchMap.get("buyerRate") != null && !"".equals(searchMap.get("buyerRate"))) {
                criteria.andLike("buyerRate", "%" + searchMap.get("buyerRate") + "%");
            }
            // 收货人
            if (searchMap.get("receiverContact") != null && !"".equals(searchMap.get("receiverContact"))) {
                criteria.andLike("receiverContact", "%" + searchMap.get("receiverContact") + "%");
            }
            // 收货人手机
            if (searchMap.get("receiverMobile") != null && !"".equals(searchMap.get("receiverMobile"))) {
                criteria.andLike("receiverMobile", "%" + searchMap.get("receiverMobile") + "%");
            }
            // 收货人地址
            if (searchMap.get("receiverAddress") != null && !"".equals(searchMap.get("receiverAddress"))) {
                criteria.andLike("receiverAddress", "%" + searchMap.get("receiverAddress") + "%");
            }
            // 订单来源：1:web，2：app，3：微信公众号，4：微信小程序  5 H5手机页面
            if (searchMap.get("sourceType") != null && !"".equals(searchMap.get("sourceType"))) {
                criteria.andEqualTo("sourceType", searchMap.get("sourceType"));
            }
            // 交易流水号
            if (searchMap.get("transactionId") != null && !"".equals(searchMap.get("transactionId"))) {
                criteria.andLike("transactionId", "%" + searchMap.get("transactionId") + "%");
            }
            // 订单状态
            if (searchMap.get("orderStatus") != null && !"".equals(searchMap.get("orderStatus"))) {
                criteria.andEqualTo("orderStatus", searchMap.get("orderStatus"));
            }
            // 支付状态
            if (searchMap.get("payStatus") != null && !"".equals(searchMap.get("payStatus"))) {
                criteria.andEqualTo("payStatus", searchMap.get("payStatus"));
            }
            // 发货状态
            if (searchMap.get("consignStatus") != null && !"".equals(searchMap.get("consignStatus"))) {
                criteria.andEqualTo("consignStatus", searchMap.get("consignStatus"));
            }
            // 是否删除
            if (searchMap.get("isDelete") != null && !"".equals(searchMap.get("isDelete"))) {
                criteria.andEqualTo("isDelete", searchMap.get("isDelete"));
            }

            // 数量合计
            if (searchMap.get("totalNum") != null) {
                criteria.andEqualTo("totalNum", searchMap.get("totalNum"));
            }
            // 金额合计
            if (searchMap.get("totalMoney") != null) {
                criteria.andEqualTo("totalMoney", searchMap.get("totalMoney"));
            }
            // 优惠金额
            if (searchMap.get("preMoney") != null) {
                criteria.andEqualTo("preMoney", searchMap.get("preMoney"));
            }
            // 邮费
            if (searchMap.get("postFee") != null) {
                criteria.andEqualTo("postFee", searchMap.get("postFee"));
            }
            // 实付金额
            if (searchMap.get("payMoney") != null) {
                criteria.andEqualTo("payMoney", searchMap.get("payMoney"));
            }

        }
        return example;
    }

}
