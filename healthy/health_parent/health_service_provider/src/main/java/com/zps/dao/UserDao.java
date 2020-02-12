package com.zps.dao;

import com.zps.pojo.Menu;
import com.zps.pojo.User;

import java.util.List;

public interface UserDao {

    User login(String username);

    List<Menu> findMenu(String username);

}
