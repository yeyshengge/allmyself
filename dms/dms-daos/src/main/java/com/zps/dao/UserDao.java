package com.zps.dao;

import com.zps.domain.User;

import java.util.List;

/**
 * Created by zps on 2019/12/29 20:46
 */
public interface UserDao {

    public List<User> findAll();
}
