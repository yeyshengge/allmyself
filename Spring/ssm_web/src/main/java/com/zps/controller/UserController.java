package com.zps.controller;

import com.zps.domain.User;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test/{id}")
    public String find(@PathVariable("id") int id, Model model){
        System.out.println(1);
        User user = userService.find(id);
        model.addAttribute("user",user);
        return "user";
    }
}
