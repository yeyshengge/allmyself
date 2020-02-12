package com.zps.service.impl;

import com.zps.dao.UserDao;
import com.zps.dao.impl.UserDaoImpl;
import com.zps.domain.User;
import com.zps.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User find(String username, String password) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.find(username, password);
        return user;
    }
}
