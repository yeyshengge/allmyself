package com.zps.controller;

import com.zps.service.AccountService;
import com.zps.service.impl.AccountServiceIml;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountServiceImpl = (AccountService) app.getBean("accountService");
        accountServiceImpl.transfer("zhangsan", "lisi", 500);
    }
}
