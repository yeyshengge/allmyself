package com.zps.web;

import com.zps.domain.User;
import com.zps.servicee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        System.out.println("test");
        return userService.findAll();
    }

    @RequestMapping("findById")
    public User findById(int id) {
        return userService.findById(id);
    }

    @RequestMapping("updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }


}
