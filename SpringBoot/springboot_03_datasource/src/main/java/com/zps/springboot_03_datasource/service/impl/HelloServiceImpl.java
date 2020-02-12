package com.zps.springboot_03_datasource.service.impl;

import com.zps.springboot_03_datasource.mapper.HelloMapper;
import com.zps.springboot_03_datasource.pojo.User;
import com.zps.springboot_03_datasource.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    @Transactional
    public void save(User user) {
        //选择性插入保存
        System.out.println("保存数据");

        helloMapper.insertSelective(user);
        //int i = 3 / 0;
    }

    @Override

    public User queryById(Integer id) {
        User user = helloMapper.selectByPrimaryKey(id);

        return user;
    }
}
