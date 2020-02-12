package com.zps.dao;

import com.zps.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper{
/*
    List<User> findAll();

    User findById(int id);*/

    List<User> demo(User user);

    List<User> demo01(List<Integer> list);

}
