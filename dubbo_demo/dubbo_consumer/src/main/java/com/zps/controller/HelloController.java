package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    //该注释会自动寻找服务
    @Reference
    private HelloService helloService;

    @RequestMapping("/sayHello")
    @ResponseBody//直接返回一段字符串
    public String sayHello(String name) {
        System.out.println(name);
        return helloService.sayHello(name);
    }
}
