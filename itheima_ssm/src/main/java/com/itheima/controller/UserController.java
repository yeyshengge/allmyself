package com.itheima.controller;

import com.itheima.domain.KeShi;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/findKind")
    public List<KeShi> findKind(HttpServletRequest request) {
        List<KeShi> list = userService.findKind();
        request.getSession().setAttribute("list", list);
        return list;
    }


    @RequestMapping("/save")
    public String save(User user) {
        System.out.println(user);
        userService.save(user);
        return "redirect:/pages/subscribe-form.jsp";
    }

    @ResponseBody
    @RequestMapping("/findAll")
    public List<User> findAll(String search, HttpServletRequest request) {
        List<User> list = userService.findAll(search);
        request.getSession().setAttribute("userList", list);
        return list;
    }

}
