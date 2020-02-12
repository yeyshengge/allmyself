package com.zps.service;

import com.zps.domain.User;
import org.springframework.stereotype.Service;


public interface UserService {

    public User find(int id);

}
