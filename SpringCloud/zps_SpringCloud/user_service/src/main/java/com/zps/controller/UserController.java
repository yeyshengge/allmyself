package com.zps.controller;

import com.zps.pojo.User;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope //刷新配置文件
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${test.username}")
    String username;

    @GetMapping("/{id}")
    public User findByID(@PathVariable Long id) {
        System.out.println(username);
        User user = userService.findById(id);
        return user;
    }
}
