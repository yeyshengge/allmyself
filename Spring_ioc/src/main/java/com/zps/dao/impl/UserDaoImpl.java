package com.zps.dao.impl;

import com.zps.dao.UserDao;
import com.zps.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    private String username;
    private int age;
    private List<String> list;
    private Map<String, User> map;
    private Properties properties;

    public UserDaoImpl(List<String> list, Map<String, User> map, Properties properties) {
        this.list = list;
        this.map = map;
        this.properties = properties;
    }


    /*public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

   /* public UserDaoImpl(String username, int age) {
        this.username = username;
        this.age = age;
    }*/

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void save() {
        //System.out.println(username + age);
        System.out.println(list);
        System.out.println(map);
        System.out.println(properties);
        System.out.println("save...");
    }

    public UserDaoImpl() {
    }
    /* public UserDaoImpl() {
        System.out.println("UserDaoImpl被创建了...");
    }
    public void init() {
        System.out.println("初始化");
    }

    public void destory() {
        System.out.println("方法摧毁");
    }*/
}
