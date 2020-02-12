package com.zps.springboot_03_datasource.service.impl;

import com.zps.springboot_03_datasource.pojo.User;
import com.zps.springboot_03_datasource.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class HelloServiceImplTest {
    @Autowired
    private HelloService helloService;

    @Test
    void save() {
        User user = new User();
        user.setAge(1122);
        user.setName("test22");
        user.setNote("test22");
        helloService.save(user);
    }

    @Test
    void queryById() {
        User user = helloService.queryById(1);
        System.out.println(user);
    }
}