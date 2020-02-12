package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zps.dao.OrderSettingDao;
import com.zps.pojo.OrderSetting;
import com.zps.service.OrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zps on 2019/12/19 9:33
 */
@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingDao orderSettingDao;

    @Override
    public void upload(List<OrderSetting> list) {
        orderSettingDao.upload(list);
    }

    @Override
    public List<Map> findAll(String date) {
        String start = date + "-1";
        String end = date + "-31";
        Map<String, String> map = new HashMap();
        map.put("start", start);
        map.put("end", end);
        List<Map> dateList = new ArrayList<>();
        List<OrderSetting> list = orderSettingDao.findAll(map);
        for (OrderSetting orderSetting : list) {
            HashMap<String, Object> map1 = new HashMap();
            map1.put("date", orderSetting.getOrderDate().getDate());
            map1.put("number", orderSetting.getNumber());
            map1.put("reservations", orderSetting.getReservations());
            dateList.add(map1);
        }
        return dateList;
    }

    @Override
    public void set(OrderSetting orderSetting) {
        orderSettingDao.set(orderSetting);
    }
}
