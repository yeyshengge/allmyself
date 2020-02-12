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

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService {

    @Autowired
    private OrderSettingDao orderSettingDao;


    @Override
    public void add(List<OrderSetting> list) {
        if (list != null && list.size() > 0) {
            for (OrderSetting orderSetting : list) {
                //查询数据查看该日期是否存在
                Long count = orderSettingDao.findDate(orderSetting.getOrderDate());
                if (count > 0) {
                    //大于0 代表数据库中已有，支持修改操作
                    orderSettingDao.editByDate(orderSetting);
                } else {
                    //代表数据库中没有，支持增加数据
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }

    @Override
    public List<Map> findPageByDate(String date) {
           /* 返回的类型：
              [ { date: 1, number: 120, reservations: 1 },
                { date: 3, number: 120, reservations: 1 },
                { date: 4, number: 120, reservations: 120 },]
                */
        String start = date + "-1";
        String end = date + "-31";
        Map<String, String> map = new HashMap<>();
        map.put("start", start);
        map.put("end", end);
        //调用方法，查询数据
        List<OrderSetting> list = orderSettingDao.findPageByDate(map);
        List<Map> data = new ArrayList<>();
        for (OrderSetting orderSetting : list) {
            Map<String, Object> m = new HashMap<>();
            m.put("date", orderSetting.getOrderDate().getDate());
            m.put("number", orderSetting.getNumber());
            m.put("reservations", orderSetting.getReservations());
            data.add(m);
        }
        return data;


    }

    @Override
    public void set(OrderSetting orderSetting) {
        //根据日期判断数据库中是否有数据
        Long count = orderSettingDao.findDate(orderSetting.getOrderDate());
        //如果有，则修改数据
        if (count > 0) {
            orderSettingDao.editByDate(orderSetting);
        } else {
            //如果没有，则添加数据
            orderSettingDao.add(orderSetting);
        }

    }
}
