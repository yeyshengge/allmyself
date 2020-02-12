package com.zps.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyuncs.exceptions.ClientException;
import com.zps.constant.MessageConstant;
import com.zps.constant.RedisMessageConstant;
import com.zps.entity.Result;
import com.zps.pojo.Order;
import com.zps.service.OrderService;
import com.zps.service.OrderSettingService;
import com.zps.utils.DateUtils;
import com.zps.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private JedisPool jedisPool;

    @Reference
    private OrderService orderService;

    @RequestMapping("/findById")
    public Result findById(Integer id) throws ClientException {
        try {
            Map map = orderService.findById(id);
            return new Result(true, MessageConstant.GET_ORDERSETTING_SUCCESS, map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_ORDERSETTING_FAIL);
        }


    }

    @RequestMapping("/submit")
    public Result submit(@RequestBody Map map) throws ClientException {
        //电话号码
        String telephone = (String) map.get("telephone");
        //通过电话号码在缓存中拿取系统验证码
        String checkCode = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_ORDER);
        //拿取用户输入的验证码
        String validateCode = (String) map.get("validateCode");
        //对比验证码是否正确
        if (checkCode != null && validateCode != null && checkCode.equals(validateCode)) {
            //调取service方法
            Result result = null;
            try {
                //添加微信预约字段信息
                map.put("orderType", Order.ORDERTYPE_WEIXIN);
                result = orderService.submit(map);
            } catch (Exception e) {
                return new Result(false, MessageConstant.ORDERSETTING_FAIL);
            }
            //数据存储之后，发送短信
            SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE, telephone, (String) map.get("orderDate"));
            return result;
        } else {
            //验证码不相符
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
    }
}
