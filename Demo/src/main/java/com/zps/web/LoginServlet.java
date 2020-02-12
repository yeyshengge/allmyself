package com.zps.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zps.domain.User;
import com.zps.service.UserService;
import com.zps.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取复选框中的值，是一个数组
        String[] checkboxes = request.getParameterValues("checkbox");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
        User user = userService.find(username, password);
        //判断是否登录成功
        if (user != null) {
            //判断是否勾选记住密码
            if (checkboxes != null && checkboxes.length > 0) {
                //设置cook信息
                Cookie cookie = new Cookie("username", username);
                Cookie cookie1 = new Cookie("password", password);
                //设置cook存活时间
                cookie.setMaxAge(99999999);
                cookie1.setMaxAge(99999999);
                //添加到cook
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
            //登录成功，重定向到成功页面
            response.sendRedirect(request.getContextPath() + "success.html");
        } else {
            //登录失败，重定向到失败页面
            response.sendRedirect(request.getContextPath() + "error.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
