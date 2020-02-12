package com.zps.springboot_03_datasource.controller;

import com.zps.springboot_03_datasource.mapper.HelloMapper;
import com.zps.springboot_03_datasource.pojo.User;
import com.zps.springboot_03_datasource.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    DataSource dataSource;

    @Value("${zps.username}")
    private String name;
    @Value("${zps.age}")
    private String age;

    @GetMapping("hello")
    @ResponseBody
    public String Hello() {
        System.out.println(dataSource);
        System.out.println(name);
        System.out.println(age);
        return "hello springboot" + dataSource;
    }

    @ResponseBody
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        User user = helloService.queryById(id);
        return user;
    }
}
