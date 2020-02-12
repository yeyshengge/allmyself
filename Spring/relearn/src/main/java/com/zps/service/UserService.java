package com.zps.service;

import java.sql.SQLException;

public interface UserService {
    public void save(String sendMan,String recMan,double money) throws SQLException;
}
