package com.zps.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zps.domain.ResultInfo;
import com.zps.domain.User;
import com.zps.service.UserService;
import com.zps.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class userServlet extends BaseServlet {

    private UserService us = new UserServiceImpl();

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        //System.out.println(username + password + code);
        String checkCode = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        ResultInfo info = new ResultInfo();
        if (!checkCode.equalsIgnoreCase(code) || "".equals("null") || "null".equals(code)) {
            //验证码错误

            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败！验证码错误,请尝试刷新验证码");

            String json = toJson(info);
            sendJson(json, response);

            return;
        }

        User user = us.regist(username, password);

        System.out.println(user);
        if (user != null) {


            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败！该用户名已被注册");

        } else {
            //代表用户名已存在
            us.save(username, password);
            info.setFlag(true);
        }
        String json = toJson(info);
        sendJson(json, response);
        System.out.println(info);
    }


    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        //System.out.println(username + password + code);
        String checkCode = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        ResultInfo info = new ResultInfo();
        if (!checkCode.equalsIgnoreCase(code) || "".equals("null") || "null".equals(code) || code == null) {
            //验证码错误

            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败！验证码错误,请尝试刷新验证码");
            String json = toJson(info);
            sendJson(json, response);
            return;
        }

        User user = us.login(username, password);


        if (user != null) {
            //登录成功
            request.getSession().setAttribute("user", user);//登录成功标记
            info.setFlag(true);


        } else {

            //登录失败
            info.setFlag(false);
            info.setErrorMsg("登录失败！账号或密码错误");

        }
        String json = toJson(info);
        sendJson(json, response);
        System.out.println(info);
    }

    public void setUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String json = toJson(user);
        sendJson(json, response);

    }

    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
    }
}



