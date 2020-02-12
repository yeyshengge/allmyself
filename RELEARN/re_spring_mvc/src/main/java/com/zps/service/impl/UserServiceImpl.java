package com.zps.service.impl;

import com.zps.dao.UserDao;
import com.zps.pojo.User;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Boolean save(User user) {
        User user1 = userDao.save(user);
        if (user1 != null) {
            return true;
        } else {
            return false;
        }
    }
}
