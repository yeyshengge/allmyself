package com.zps;

import com.zps.dao.UserMapper;
import com.zps.domain.User;
import com.zps.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class Demo {
    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        User user = userService.find(1);
        System.out.println(user);
    }

}
