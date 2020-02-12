package com.zps.rabbitmq.routing;

import com.rabbitmq.client.*;
import com.zps.utils.SimpleRabbitMQUtil;

import java.io.IOException;

/**
 * 简单消息
 */
public class Consumer1 {
    public static void main(String[] args) throws Exception {
        //1.获取工厂
        //2.获取连接
        Connection connection = SimpleRabbitMQUtil.getConnection();

        //3.获取频道
        final Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(Producer.ROUTING, BuiltinExchangeType.DIRECT);
        //4. 声明队列；
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列（消息会持久化保存在服务器上）
         * 参数3：是否独占本连接
         * 参数4：是否在不使用的时候队列自动删除
         * 参数5：其它参数
         */
        channel.queueDeclare(Producer.QUEUE_NAME_INSERT, true, false, false, null);
        //预期接收一条
        channel.basicQos(2);
        //绑定列队
        channel.queueBind(Producer.QUEUE_NAME_INSERT, Producer.ROUTING, "insert");
        //5，创建消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    System.out.println("路由key:" + envelope.getRoutingKey());
                    System.out.println("交换机:" + envelope.getExchange());
                    System.out.println("消息id:" + envelope.getDeliveryTag());
                    System.out.println("消费者insert一接收信息为:" + new String(body, "utf-8"));
                    Thread.sleep(1000);
                    //确定消费，
                    // 参数一：代表消息id
                    //参数二：false代表当前这条被消费
                    channel.basicAck(envelope.getDeliveryTag(), false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //6. 监听队列
        /**
         * 参数1：队列名
         * 参数2：是否要自动确认；设置为true表示消息接收到自动向MQ回复接收到了，MQ则会将消息从队列中删除；
         * 如果设置为false则需要手动确认
         * 参数3：消费者
         */
        channel.basicConsume(Producer.QUEUE_NAME_INSERT, true, defaultConsumer);

    }
}
