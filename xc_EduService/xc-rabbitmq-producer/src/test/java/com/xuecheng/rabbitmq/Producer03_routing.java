package com.xuecheng.rabbitmq;


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by zps on 2020/1/2 19:32
 */
public class Producer03_routing {

    private static final String QUEUE_EMAIL = "email";
    private static final String QUEUE_MSG = "msg";
    private static final String EXCHANGE_DIRECT = "HelloWord_direct";
    private static final String EMAIL_ROUTING = "email_routing";
    private static final String SMS_ROUTING = "sms_routing";

    //消息队列入门
    public static void main(String[] args) {

        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置工厂相关信息
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("root");
        connectionFactory.setPort(5672);
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setVirtualHost("/root");
        //创建连接
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection();
            //获取管道
            channel = connection.createChannel();
            /**
             * String exchange, 交换机名称
             * BuiltinExchangeType type 交换机类型
             * FANOUT    发布与订阅模式
             * DIRECT    路由模式
             * TOPIC     通配符模式
             * HEADERS   对应headers模式
             */
            channel.exchangeDeclare(EXCHANGE_DIRECT, BuiltinExchangeType.DIRECT);
            /**
             * 声明队列
             * param1:队列名称
             * param2:是否持久化
             * param3:队列是否独占此连接
             * param4:队列不再使用时是否自动删除此队列
             * param5:队列参数
             */
            channel.queueDeclare(QUEUE_EMAIL, true, false, false, null);
            channel.queueDeclare(QUEUE_MSG, true, false, false, null);

            /**
             * 交换机与队列绑定
             * String queue,            列队名称
             * String exchange,         交换机名称
             * String routingKey        路由key
             */
            channel.queueBind(QUEUE_EMAIL, EXCHANGE_DIRECT, EMAIL_ROUTING);
            channel.queueBind(QUEUE_MSG, EXCHANGE_DIRECT, SMS_ROUTING);
            /**
             * 消息发布
             * param1：Exchange的名称，如果没有指定，则使用Default Exchange
             * param2:routingKey,消息的路由Key，是用于Exchange（交换机）将消息转发到指定的消息队列
             * param3:消息包含的属性
             * param4：消息体
             * 这里没有指定交换机，消息将发送给默认交换机，每个队列也会绑定那个默认的交换机，但是不能显
             示绑定或解除绑定
             * 默认的交换机，routingKey等于队列名称
             */
            for (int i = 0; i < 5; i++) {
                String message = "fuck RabbitMQ" + i;
                channel.basicPublish(EXCHANGE_DIRECT, SMS_ROUTING, null, message.getBytes());
                System.out.println("send message :" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
