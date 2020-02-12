package com.itheima.mapper;

import com.itheima.domain.KeShi;
import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    List<KeShi> findKind();


    void save(User user);

    List<User> findAll(String search);
}
