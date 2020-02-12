package com.zps.dao;

public interface UserDao {

    public void send(String sendMan, double money);

    public void recive(String recMan, double money);
}
