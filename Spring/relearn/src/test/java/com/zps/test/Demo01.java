package com.zps.test;

import com.zps.dao.UserDao;

import com.zps.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        userService.save("lisi","zhangsan",1000);
    }

}
