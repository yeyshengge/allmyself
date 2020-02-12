package com.itheima.service.impl;

import com.itheima.domain.KeShi;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<KeShi> findKind() {
        return userMapper.findKind();
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public List<User> findAll(String search) {
        return userMapper.findAll(search);
    }
}
