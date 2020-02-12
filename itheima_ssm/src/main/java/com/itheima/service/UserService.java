package com.itheima.service;

import com.itheima.domain.KeShi;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    List<KeShi> findKind();


    void save(User user);

    List<User> findAll(String search);

}
