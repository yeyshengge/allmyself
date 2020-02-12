package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.zps.constant.MessageConstant;
import com.zps.constant.RedisMessageConstant;
import com.zps.entity.Result;
import com.zps.pojo.Member;
import com.zps.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class MemberController {

    @Autowired
    private JedisPool jedisPool;
    @Reference
    private MemberService memberService;

    @RequestMapping("/check")
    public Result login(HttpServletResponse response, @RequestBody Map map) {
        //获取页面数据
        String telephone = (String) map.get("telephone");
        String validateCode = (String) map.get("validateCode");
        //获取缓存的验证码信息
        String checkCode = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_LOGIN);
        if (checkCode != null && validateCode != null && checkCode.equals(validateCode)) {
            //验证码正确
            //判断是否是会员
            Member member = memberService.findByTelephone(telephone);
            if (member == null) {
                //代表不是会员，则进行注册
                member = new Member();
                member.setRegTime(new Date());
                member.setPhoneNumber(telephone);
                memberService.add(member);
            }
            //写入Cook
            Cookie cookie = new Cookie("Login_Telephone", telephone);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 30);//有效期为30天
            response.addCookie(cookie);
            //存入redis
            String json = JSON.toJSON(member).toString();
            jedisPool.getResource().setex(telephone, 60 * 30, json);
            return new Result(true, MessageConstant.LOGIN_SUCCESS);
        } else {
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
    }
}
