package com.zps.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/1/3 15:11
 */
@Component
public class ReceiveHandler {
    //监听email队列
    @RabbitListener(queues = {ProducerConfig.QUEUE_EMAIL})
    public void receive_email(String msg, Message message, Channel channel) {
        System.out.println(msg);
    }

    //监听sms队列
    @RabbitListener(queues = {ProducerConfig.QUEUE_SMS})
    public void receive_sms(String msg, Message message, Channel channel) {
        System.out.println(msg);
    }

}
