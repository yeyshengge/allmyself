package com.zps.dao;

import com.zps.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public List<User> findAll2();
}
