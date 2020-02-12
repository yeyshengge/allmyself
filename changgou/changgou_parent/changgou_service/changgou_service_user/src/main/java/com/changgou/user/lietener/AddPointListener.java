package com.changgou.user.lietener;

import com.alibaba.fastjson.JSON;
import com.changgou.order.pojo.Task;
import com.changgou.user.config.RabbitMQConfig;
import com.changgou.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/2/6 18:37
 */
@Component
public class AddPointListener {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RabbitListener(queues = RabbitMQConfig.CG_BUYING_ADDPOINT)
    public void addPoint(String message) {

        System.out.println("-- 2 --监听增加积分队列接收到数据： " + message);
        Task task = JSON.parseObject(message, Task.class);

        if (task == null || StringUtils.isEmpty(task.getRequestBody())) {
            return;
        }

        //判断redis中是否存在
        Object value = redisTemplate.boundValueOps(task.getId()).get();

        if (value != null) {
            return;
        }
        //更新用户积分
        int result = userService.updateUserPoint(task);
        if (result == 0) {
            return;
        }
        //向订单服务返回通知数据

        rabbitTemplate.convertAndSend(RabbitMQConfig.EX_BUYING_ADDPOINTUSER, RabbitMQConfig.CG_BUYING_FINISHADDPOINT_KEY, JSON.toJSONString(task));

        System.out.println("-- 3 -- 成功添加积分并且把已处理的数据发给已完成队列 ： "+JSON.toJSONString(task));

    }
}
