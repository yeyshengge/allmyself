package com.zps.service.impl;

import com.zps.dao.UserDao;
import com.zps.dao.impl.UserDaoImpl;
import com.zps.domain.User;
import com.zps.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();
    @Override
    public User regist(String username, String password) {
      User user = ud.registe(username,password);
      return user;
    }

    @Override
    public void save(String username, String password) {
        ud.save(username,password);
    }

    @Override
    public User login(String username, String password) {

        User user = ud.login(username,password);
        return user;
    }
}
