package com.changgou.order.listener;

import com.alibaba.fastjson.JSON;
import com.changgou.order.config.RabbitMQConfig;
import com.changgou.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by zps on 2020/2/9 21:08
 */
@Component
public class OrderPayListener {


    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = RabbitMQConfig.ORDER_PAY)
    public void receiveOrderPay(String message) {
        System.out.println("接收到支付订单信息 : " + message);

        //获取数据
        Map map = JSON.parseObject(message, Map.class);
        //更新订单数据
        orderService.updateOrderStatus((String) map.get("orderId"), (String) map.get("transactionId"));

    }
}
