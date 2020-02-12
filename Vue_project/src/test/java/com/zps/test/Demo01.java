package com.zps.test;

import com.zps.domain.User;
import com.zps.servicee.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Demo01 {
    @Autowired
    private UserService userService;

    //测试查询所有的方法
    @Test
    public void findAll() {
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    //测试查询一个的方法
    @Test
    public void findById() {
        User user = userService.findById(1);
        System.out.println(user);
    }

    //测试修改方法
    @Test
    public void updateUser(){
        User user = userService.findById(1);
        System.out.println("修改前"+user);
        user.setUsername("西红柿");
        userService.updateUser(user);
        user=userService.findById(1);
        System.out.println("修改后"+user);
    }
}
