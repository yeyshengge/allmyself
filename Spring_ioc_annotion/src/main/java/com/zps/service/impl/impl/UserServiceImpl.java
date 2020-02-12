package com.zps.service.impl.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.zps.dao.impl.UserDaoImpl;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// <bean id="userService" class="com.zps.service.impl.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    //@Qualifier("userDao")
    //@Resource(name = "userDao")
    private UserDaoImpl userDao;
    @Value("${driver}")
    private String name;
    /*public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }*/


    public void save() {
        System.out.println(name);
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }
    @PreDestroy
    public void destory(){
        System.out.println("摧毁方法");
    }



}
