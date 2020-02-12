package com.changgou.Task;

import com.changgou.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/2/11 15:59
 */

@Component
public class OrderTask {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "0 0 0 * * ?")
    public void autoTake() {

        //向队列发送一条信息
        rabbitTemplate.convertAndSend("", RabbitMQConfig.ORDER_TACK,"author:zps");

    }
}
