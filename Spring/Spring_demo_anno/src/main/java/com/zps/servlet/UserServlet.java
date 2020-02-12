package com.zps.servlet;

import com.zps.config.SpringContextConfiguration;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServlet {


    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
        UserService userService = (UserService) app.getBean("userService");
        userService.save();

    }
}
