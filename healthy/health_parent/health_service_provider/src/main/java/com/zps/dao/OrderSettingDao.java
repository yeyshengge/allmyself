package com.zps.dao;

import com.zps.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {

    public Long findDate(Date date);

    public void editByDate(OrderSetting orderSetting);

    public void add(OrderSetting orderSetting);

    public List<OrderSetting> findPageByDate(Map map);
    //根据预约日期查询预约设置信息
    public OrderSetting findByOrderDate(Date orderDate);
    //用户新增预约后，改日预约人数加一
    public void updateReservation(OrderSetting orderSetting);
}
