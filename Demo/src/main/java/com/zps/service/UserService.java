package com.zps.service;

import com.zps.domain.User;

public interface UserService {

    User find(String username, String password);

}
