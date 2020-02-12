package com.zps.control;

import com.zps.dao.impl.UserDaoImpl;
import com.zps.service.UserDaoService;
import com.zps.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserControll {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext app =  new FileSystemXmlApplicationContext("D:\\ideaspacework\\Spring\\src\\main\\resources\\applicationContext.xml");
        //UserDaoService userService = (UserDaoService) app.getBean("userService");
        UserDaoService userService = app.getBean(UserDaoService.class);
        //UserDaoService userService = new UserServiceImpl();//NullPointerException
        userService.save();
    }
}
