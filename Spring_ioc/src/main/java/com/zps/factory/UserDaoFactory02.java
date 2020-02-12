package com.zps.factory;

import com.zps.dao.UserDao;
import com.zps.dao.impl.UserDaoImpl;

//非静态方法创建
public class UserDaoFactory02 {


    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
