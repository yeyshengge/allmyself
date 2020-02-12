package com.zps.dao.impl;

import com.zps.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save方法执行了。。。");
    }
}
