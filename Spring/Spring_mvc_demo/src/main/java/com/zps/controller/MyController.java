package com.zps.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/test01")
    public String test01() {
        System.out.println("进来了");
        return "success.jsp";
    }
}
