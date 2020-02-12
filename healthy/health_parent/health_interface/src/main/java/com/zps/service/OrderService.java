package com.zps.service;

import com.zps.entity.Result;

import java.util.Map;

public interface OrderService {

    public Result submit(Map map) throws Exception;

    public Map findById(Integer id);
}
