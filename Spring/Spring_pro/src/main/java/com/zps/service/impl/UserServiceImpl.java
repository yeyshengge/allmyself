package com.zps.service.impl;

import com.zps.dao.UserDao;
import com.zps.domain.Role;
import com.zps.domain.User;
import com.zps.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> list() {
        List<User> list = userDao.list();
        for (User user : list) {
            List<Role> list1 = userDao.findById(user.getId());
            user.setRoles(list1);
        }
        return list;
    }

    @Override
    public void save(User user, Long[] roles) {
        Long index = userDao.save(user);

        userDao.saveUidAndRid(index,roles);
    }

    @Override
    public void remove(int id) {
        userDao.remove(id);
    }
}
