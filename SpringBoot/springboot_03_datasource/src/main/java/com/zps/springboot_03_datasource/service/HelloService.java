package com.zps.springboot_03_datasource.service;

import com.zps.springboot_03_datasource.pojo.User;

import java.util.List;

public interface HelloService {

    public void save(User user);

    public User queryById(Integer id);
}
