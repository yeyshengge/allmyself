package com.zps.dao;

import com.zps.domain.User;

public interface UserDao {
    User find(String username, String password);

}
