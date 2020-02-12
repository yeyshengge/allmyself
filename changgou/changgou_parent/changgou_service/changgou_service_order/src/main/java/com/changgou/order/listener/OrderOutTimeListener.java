package com.changgou.order.listener;

import com.changgou.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/2/10 21:01
 */
@Component
public class OrderOutTimeListener {

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "queue.ordertimeout")
    public void receiveOutTimeOrder(String message) {
        System.out.println("监听到订单创建成功，用来判断到期是否支付的id ： " + message);
        try {

            orderService.closeOrder(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
