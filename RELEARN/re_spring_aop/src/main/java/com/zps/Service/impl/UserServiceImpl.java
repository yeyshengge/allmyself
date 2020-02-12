package com.zps.Service.impl;

import com.zps.Service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    public void save() {
        System.out.println("save Running...");
    }
}
