package com.zps.config;


import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zps on 2020/1/3 8:41
 */
@Configuration
public class ProducerConfig {

    public static final String QUEUE_EMAIL = "email";
    public static final String QUEUE_SMS = "sms";
    public static final String EXCHANGE_TOPIC = "topic_spring_test";


    //声明交换机
    @Bean(EXCHANGE_TOPIC)
    public Exchange EXCHANGE_TOPIC() {
        //durable 是否持久化
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPIC).durable(true).build();
    }

    //声明队列
    @Bean(QUEUE_EMAIL)
    public Queue QUEUE_EMAIL() {
        //durable 是否持久化
        return new Queue(QUEUE_EMAIL);
    }

    @Bean(QUEUE_SMS)
    public Queue QUEUE_SMS() {
        //durable 是否持久化
        return new Queue(QUEUE_SMS);
    }

    //绑定
    public Binding BING_QUEUE_EMAIL(@Qualifier(QUEUE_EMAIL) Queue queue, @Qualifier(EXCHANGE_TOPIC) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("info.#.sms.#").noargs();
    }

    public Binding BING_QUEUE_SMS(@Qualifier(QUEUE_SMS) Queue queue, @Qualifier(EXCHANGE_TOPIC) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("info.#.email.#").noargs();
    }

}
