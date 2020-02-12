package com.zps.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

 /*   *//**
     * 列队名与生产者的列队要以一致
     *
     * @param message
     *//*
    @RabbitListener(queues = "DIRECT_QUEUE" )
    public void Listener1(String message) {
        System.out.println("消费的信息为：" + message);

    }
*/

}
