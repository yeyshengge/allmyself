package com.zps.service;

import com.zps.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * Created by zps on 2019/12/19 9:33
 */
public interface OrderSettingService {

    void upload(List<OrderSetting> list);

    List<Map> findAll(String date);

    void set(OrderSetting orderSetting);


}
