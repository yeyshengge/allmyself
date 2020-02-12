package com.zps.controller;

import com.zps.pojo.User;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by zps on 2020/1/19 15:31
 */
@Controller
@RequestMapping("/thymeleaf")
public class DemoController {


    @RequestMapping("/test01")
    public String test01(Model model, String name) {
        model.addAttribute("name", name);
        List<User> userList = new ArrayList<>();

        User user1 = new User("1", "zhangsan", "12", "cs");
        User user2 = new User("2", "lisi", "20", "sh");
        User user3 = new User("3", "wangwu", "21", "sz");
        User user4 = new User("4", "zhaoliu", "22", "gz");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        model.addAttribute("userList", userList);

        Map<String, String> map = new HashMap<>();
        map.put("NO", "123");
        map.put("address", "上海");

        model.addAttribute("dataMap", map);

        String[] arr = {"张三", "李四", "王五"};
        model.addAttribute("arr", arr);

        model.addAttribute("now", new Date());

        model.addAttribute("age", 20);
        return "test01";


    }
}
