package com.zps.controller;

import com.aliyuncs.exceptions.ClientException;
import com.zps.constant.MessageConstant;
import com.zps.constant.RedisMessageConstant;
import com.zps.entity.Result;
import com.zps.utils.SMSUtils;
import com.zps.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/sendMessage")
public class ValidateCodeController {

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/send")
    public Result send(String telephone) {
        //获取验证码
        Integer integer = ValidateCodeUtils.generateValidateCode(6);
        //发送验证码
        try {
            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE, telephone, integer.toString());
            //把验证码存在redis中，为了以后做比较
            //设置五分钟时间销毁
            jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_ORDER, 300, integer.toString());
        } catch (ClientException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);

    }

    @RequestMapping("/send4Login")
    public Result send4Login(String telephone) {
        //获取验证码
        Integer integer = ValidateCodeUtils.generateValidateCode(6);
        //发送验证码
        try {
            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE, telephone, integer.toString());
            //把验证码存在redis中，为了以后做比较
            //设置五分钟时间销毁
            jedisPool.getResource().setex(telephone + RedisMessageConstant.SENDTYPE_LOGIN, 300, integer.toString());
        } catch (ClientException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);


    }

}
