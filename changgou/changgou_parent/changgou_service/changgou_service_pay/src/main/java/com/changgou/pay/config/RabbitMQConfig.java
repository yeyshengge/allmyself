package com.changgou.pay.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zps on 2020/2/9 20:52
 */
@Configuration
public class RabbitMQConfig {

    public static final String ORDER_PAY = "order_pay";

    @Bean(ORDER_PAY)
    public Queue ORDER_PAY() {
        return new Queue(ORDER_PAY);
    }
}
