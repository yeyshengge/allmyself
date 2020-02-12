package com.zps.dao;

import com.zps.pojo.OrderSetting;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by zps on 2019/12/19 10:19
 */
public interface OrderSettingDao {

    void upload(@Param("list") List<OrderSetting> list);

    List<OrderSetting> findAll(Map<String, String> map);

    void set(OrderSetting orderSetting);

}
