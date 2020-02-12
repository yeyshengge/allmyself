package com.zps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Demo {
    @RequestMapping("/test01")
    public ModelAndView test01() {
        System.out.println("controller进来了");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "zhangsan");
        modelAndView.setViewName("target");
        return modelAndView;
    }
}
