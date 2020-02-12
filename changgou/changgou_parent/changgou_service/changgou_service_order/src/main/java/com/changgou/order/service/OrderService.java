package com.changgou.order.service;

import com.changgou.order.pojo.Order;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface OrderService {

    /***
     * 查询所有
     * @return
     */
    List<Order> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Order findById(String id);

    /***
     * 新增
     * @param order
     */
    String add(Order order);

    /***
     * 修改
     * @param order
     */
    void update(Order order);

    /***
     * 删除
     * @param id
     */
    void delete(String id);

    /***
     * 多条件搜索
     * @param searchMap
     * @return
     */
    List<Order> findList(Map<String, Object> searchMap);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    Page<Order> findPage(int page, int size);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Order> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 支付成功修改订单数据
     * @param orderId
     * @param transactionId
     */
    void updateOrderStatus(String orderId, String transactionId);

    /**
     * 关闭订单
     * @param message
     */
    void closeOrder(String message);

    /**
     * 批量设置订单物流
     * @param orderList
     */
    void batchSend(List<Order> orderList);


    /**
     * 手动确定订单
     * @param orderId
     * @param operator
     */
    void confirmTask(String orderId,String operator);


    /**
     * 自动确定收货
     */
    void orderTack();

}
