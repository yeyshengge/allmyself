package com.zps.service.impl;

import com.zps.mapper.UserMapper;
import com.zps.pojo.User;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
