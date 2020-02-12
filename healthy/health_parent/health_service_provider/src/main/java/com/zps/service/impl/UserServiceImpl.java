package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zps.dao.UserDao;
import com.zps.entity.Result;
import com.zps.pojo.Menu;
import com.zps.pojo.User;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = UserService.class)
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username) {

        User login = userDao.login(username);
        System.out.println(login);
        return login;
    }

    @Override
    public Result findMenu(String username) {
        List<Menu> menuList = new ArrayList<>();
        Menu before = new Menu();
        before.setId(0);
        before.setPath("1");
        before.setName("工作台");
        before.setIcon("icon");
        before.setChildren(new ArrayList<>());
        menuList.add(before);
        List<Menu> list = userDao.findMenu(username);
        for (Menu menu : list) {
            if (menu.getParentMenuId() == null || menu.getParentMenuId() <= 0) {
                menuList.add(menu);
            }
        }
        for (Menu menu : menuList) {
            List<Menu> data = new ArrayList<>();
            for (Menu child : list) {
                if (menu.getId() == child.getParentMenuId()) {
                    data.add(child);
                }
            }
            menu.setChildren(data);
        }
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
        return new Result(true, null, menuList);
    }
}
