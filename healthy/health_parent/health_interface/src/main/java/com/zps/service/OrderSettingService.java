package com.zps.service;

import com.zps.entity.Result;
import com.zps.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {

    public void add(List<OrderSetting> list);

    public List<Map> findPageByDate(String date);

    public void set(OrderSetting orderSetting);

}
