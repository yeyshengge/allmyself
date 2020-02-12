package com.zps.service;

import com.zps.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void save(User user, Long[] roles);

    void remove(int id);

}
