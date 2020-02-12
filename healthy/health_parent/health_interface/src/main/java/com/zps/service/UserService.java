package com.zps.service;

import com.zps.entity.Result;
import com.zps.pojo.User;

public interface UserService {

    User login(String username);

    Result findMenu(String username);

}
