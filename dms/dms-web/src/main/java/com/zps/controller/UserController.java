package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.domain.PageInfo;
import com.zps.domain.User;
import com.zps.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zps on 2019/12/29 19:56
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Reference
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<User> all = userService.findAll();
        System.out.println(all);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<User> pageInfo = new PageInfo<>();
        pageInfo.setList(all);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("/pages/user/user-list.jsp");
        return modelAndView;
    }
}
