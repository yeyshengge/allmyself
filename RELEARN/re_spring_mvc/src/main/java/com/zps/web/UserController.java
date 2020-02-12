package com.zps.web;

import com.zps.pojo.User;
import com.zps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    public String test(User user) {
        System.out.println(user);
        Boolean flag = userService.save(user);
        if (flag == true) {
            return "success";
        } else {
            return "fail";
        }


    }
}
