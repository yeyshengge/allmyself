package com.zps.dao;

import com.zps.domain.User;

public interface UserDao {
    User registe(String username, String password);

    void save(String username, String password);

    User login(String username, String password);
}
