package com.zps.service;

import com.zps.dao.UserMapper;
import com.zps.domain.User;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User find(int id) {
        return userMapper.find(id);
    }
}
