package com.zps.factory;

import com.zps.dao.UserDao;
import com.zps.dao.impl.UserDaoImpl;

public class UserDaoFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }
}
