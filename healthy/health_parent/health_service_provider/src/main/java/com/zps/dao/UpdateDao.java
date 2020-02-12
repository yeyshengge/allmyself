package com.zps.dao;

import com.zps.pojo.OrderSetting;

import java.util.List;

/**
 * Created by zps on 2019/12/23 21:15
 */
public interface UpdateDao {

    public void updateJob(List<OrderSetting> list);

}
