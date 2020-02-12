package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zps.entity.Result;
import com.zps.service.UserService;
import org.apache.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by zps on 2019/12/25 10:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/findUsername")
    public Result findUsername(HttpServletRequest request) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return new Result(true, null, name);
    }

    @RequestMapping("/findMenu")
    public Result findMenu() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return userService.findMenu(username);
    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request) {
        String remoteUser = request.getRemoteUser();
        String requestedSessionId = request.getRequestedSessionId();
        String remoteAddr = request.getRemoteAddr();
        String re = request.getRequestedSessionId();
        System.out.println("remoteUser" + remoteUser);
        System.out.println("requestedSessionId" + requestedSessionId);
        System.out.println("remoteAddr" + remoteAddr);
        System.out.println("re" + re);
    }

    @RequestMapping("/tuichu")
    public void tuichu(HttpServletRequest request) {

    }


}
