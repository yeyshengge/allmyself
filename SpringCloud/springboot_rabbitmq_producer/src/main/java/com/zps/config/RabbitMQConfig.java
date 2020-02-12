package com.zps.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
    //声明交换机名称
    public static final String DIRECT_EXCHANGE = "DIRECT_EXCHANGE";
    //声明列队名称
    public static final String DIRECT_QUEUE = "DIRECT_QUEUE";
    //声明交换机名称
    public static final String DIRECT_EXCHANGE_TTL = "DIRECT_EXCHANGE_TTL";
    //声明列队名称
    public static final String DIRECT_QUEUE_TTL = "DIRECT_QUEUE_TTL";

    //声明交换机
    @Bean("exchange_TTL")
    public Exchange getExchangeTTL() {
        //交换机建造者.交换机类型.是否持久化.建造
        return ExchangeBuilder.directExchange(DIRECT_EXCHANGE_TTL).durable(true).build();
    }

    //声明列队
    @Bean("queue_TTL")
    public Queue getQueueTTL() {
        //TTL队列，时间到了会自动删除
        return QueueBuilder.durable(DIRECT_QUEUE_TTL).ttl(10000).build();
    }

    //声明绑定
    @Bean
    //@Qualifier 指定类型注入（把前面两个注入到参数）
    public Binding getBindingTTL(@Qualifier("exchange_TTL") Exchange exchange, @Qualifier("queue_TTL") Queue queue) {
        //绑定建造者.绑定列队（列队名称）.给（交换机名称）.路由key.是否还有其他参数
        //绑定的路由key代表可以传输出去的信息（符合规则的）
        return BindingBuilder.bind(queue).to(exchange).with("info").noargs();
    }


    //声明交换机
    @Bean("exchange")
    public Exchange getExchange() {
        //交换机建造者.交换机类型.是否持久化.建造
        return ExchangeBuilder.directExchange(DIRECT_EXCHANGE).durable(true).build();
    }

    //声明列队
    @Bean("queue")
    public Queue getQueue() {
        //列队建造者.列队名称.建造
        return QueueBuilder.durable(DIRECT_QUEUE).build();
    }

    //声明绑定
    @Bean
    //@Qualifier 指定类型注入（把前面两个注入到参数）
    public Binding getBinding(@Qualifier("exchange") Exchange exchange, @Qualifier("queue") Queue queue) {
        //绑定建造者.绑定列队（列队名称）.给（交换机名称）.路由key.是否还有其他参数
        //绑定的路由key代表可以传输出去的信息（符合规则的）
        return BindingBuilder.bind(queue).to(exchange).with("info").noargs();
    }




    /**
    **********************************************************************************************************
     */


    //声明交换机
    @Bean("exchange_test")
    public Exchange getExchange_test() {
        //交换机建造者.交换机类型.是否持久化.建造
        return ExchangeBuilder.topicExchange("topic_test").durable(true).build();
    }

    //声明列队
    @Bean("queue_test")
    public Queue getQueue_test() {
        /**
         * 死信交换机名称
         * 死信交换机路由key
         * 设置信息最大长度（个数）
         * 设置信息存活时间
         */
        return QueueBuilder.durable("queue_test").deadLetterExchange("topic_dlx").deadLetterRoutingKey("dlx.hehe").maxLength(10).ttl(10000).build();
    }

    //声明绑定
    @Bean
    //@Qualifier 指定类型注入（把前面两个注入到参数）
    public Binding getBinding_test(@Qualifier("exchange_test") Exchange exchange, @Qualifier("queue_test") Queue queue) {
        //绑定建造者.绑定列队（列队名称）.给（交换机名称）.路由key.是否还有其他参数
        //绑定的路由key代表可以传输出去的信息（符合规则的）
        return BindingBuilder.bind(queue).to(exchange).with("test.#").noargs();
    }


    /**
     *************************************************死信队列*********************************************************
     */


    //声明交换机
    @Bean("exchange_dlx")
    public Exchange getExchange_dlx() {
        //交换机建造者.交换机类型.是否持久化.建造
        return ExchangeBuilder.topicExchange("topic_dlx").durable(true).build();
    }

    //声明列队
    @Bean("queue_dlx")
    public Queue getQueue_dlx() {
        //列队建造者.列队名称.建造
        return QueueBuilder.durable("queue_dlx").build();
    }

    //声明绑定
    @Bean
    //@Qualifier 指定类型注入（把前面两个注入到参数）
    public Binding getBinding_dlx(@Qualifier("exchange_dlx") Exchange exchange, @Qualifier("queue_dlx") Queue queue) {
        //绑定建造者.绑定列队（列队名称）.给（交换机名称）.路由key.是否还有其他参数
        //绑定的路由key代表可以传输出去的信息（符合规则的）
        return BindingBuilder.bind(queue).to(exchange).with("dlx.#").noargs();
    }




}
