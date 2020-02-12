package com.zps.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('add')")
    public String add() {
        System.out.println("ad进来了");
        return "success";
    }

    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete() {
        System.out.println("delete进来了");
        return "success";
    }
}
