package com.changgou.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/2/11 15:52
 */
@Configuration
public class RabbitMQConfig {

    public static final String ORDER_TACK = "order_tack";

    @Bean(ORDER_TACK)
    public Queue ORDER_TACK(){
        return new Queue(ORDER_TACK);
    }
}
