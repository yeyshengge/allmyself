package com.zps.service.impl;

import com.zps.dao.UserDao;
import com.zps.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void save() {
     userDao.save();
    }
}
