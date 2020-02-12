package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zps.constant.MessageConstant;
import com.zps.dao.MemberDao;
import com.zps.dao.OrderDao;
import com.zps.dao.OrderSettingDao;
import com.zps.entity.Result;
import com.zps.pojo.Member;
import com.zps.pojo.Order;
import com.zps.pojo.OrderSetting;
import com.zps.service.OrderService;
import com.zps.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = OrderService.class)
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private MemberDao memberDao;

    @Autowired
    private OrderSettingDao orderSettingDao;

    @Override
    public Result submit(Map map) throws Exception {
        //1、检查用户所选择的预约日期是否已经提前进行了预约设置，如果没有设置则无法进行预约
        String orderDate = (String) map.get("orderDate");
        Date date = DateUtils.parseString2Date(orderDate);
        OrderSetting orderSetting = orderSettingDao.findByOrderDate(date);
        if (orderSetting == null) {
            //没有查到就代表改天没有进行设置预约
            return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }
        //2、检查用户所选择的预约日期是否已经约满，如果已经约满则无法预约
        if (orderSetting.getReservations() >= orderSetting.getNumber()) {
            //代表预约人数已达上
            return new Result(false, MessageConstant.ORDER_FULL);
        }
        //3、检查用户是否重复预约（同一个用户在同一天预约了同一个套餐），如果是重复预约 则无法完成再次预约
        String telephone = (String) map.get("telephone");
        Member number = memberDao.findByTelephone(telephone);
        if (number != null) {
            //代表注册了会员
            Date date1 = DateUtils.parseString2Date((String) map.get("orderDate"));
            String setmealId = (String) map.get("setmealId");
            Integer id = number.getId();
            Order order = new Order();
            order.setMemberId(id);
            order.setOrderDate(date1);
            order.setSetmealId(Integer.parseInt(setmealId));
            //通过上面三个字段查询是否存在数据
            List<Order> orderList = orderDao.findByCondition(order);
            if (orderList != null && orderList.size() > 0) {
                //代表重复预约
                return new Result(false, MessageConstant.HAS_ORDERED);
            }
        } else {
            //4、检查当前用户是否为会员，如果是会员则直接完成预约，如果不是会员则自动完成注册并进行预约
            number = new Member();
            number.setName((String) map.get("name"));
            number.setPhoneNumber((String) map.get("telephone"));
            number.setSex((String) map.get("sex"));
            number.setRegTime(DateUtils.parseString2Date((String) map.get("orderDate")));
            number.setIdCard((String) map.get("idCard"));
            //调用add方法，该方法会把存储的id封装在number中
            memberDao.add(number);
        }
        //5、预约成功，更新当日的已预约人数
        //在order表中添加订单信息
        Order order = new Order();
        order.setMemberId(number.getId());
        order.setSetmealId(Integer.parseInt((String) map.get("setmealId")));
        order.setOrderDate(DateUtils.parseString2Date((String) map.get("orderDate")));
        order.setOrderStatus(Order.ORDERSTATUS_NO);
        order.setOrderType((String) map.get("orderType"));
        orderDao.add(order);
        //更新t_ordersetting中已预约的人数
        orderSetting.setReservations(orderSetting.getReservations() + 1);
        orderSettingDao.updateReservation(orderSetting);
        //返回页面
        return new Result(true, MessageConstant.ORDER_SUCCESS, order.getId());
    }

    @Override
    public Map findById(Integer id) {
        Map map = orderDao.findById4Detail(id);
        return map;
    }
}
