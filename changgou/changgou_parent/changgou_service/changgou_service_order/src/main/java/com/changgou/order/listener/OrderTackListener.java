package com.changgou.order.listener;

import com.changgou.order.config.RabbitMQConfig;
import com.changgou.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/2/11 16:12
 */
@Component
public class OrderTackListener {


    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = RabbitMQConfig.ORDER_TACK)
    public void receiveOrderTack(String message) {
        System.out.println("自动收货收到了一条信息 : " + message);
        //调用业务知识
        orderService.orderTack();
    }
}
