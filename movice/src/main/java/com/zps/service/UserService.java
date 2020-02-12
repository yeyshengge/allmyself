package com.zps.service;

import com.zps.domain.User;

public interface UserService {
    User regist(String username, String password);

    void save(String username, String password);

    User login(String username, String password);
}
