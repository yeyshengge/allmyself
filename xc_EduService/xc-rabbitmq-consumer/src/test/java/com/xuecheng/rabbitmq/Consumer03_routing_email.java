package com.xuecheng.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by zps on 2020/1/2 20:10
 */
public class Consumer03_routing_email {

    private static final String QUEUE_EMAIL = "email";
    private static final String EXCHANGE_DIRECT = "HelloWord_direct";
    private static final String EMAIL_ROUTING = "email_routing";

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
             * 声明队列
             * param1:队列名称
             * param2:是否持久化
             * param3:队列是否独占此连接
             * param4:队列不再使用时是否自动删除此队列
             * param5:队列参数
             */
            channel.queueDeclare(QUEUE_EMAIL, true, false, false, null);
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
             * 交换机与队列绑定
             * String queue,            列队名称
             * String exchange,         交换机名称
             * String routingKey        路由key
             */
            channel.queueBind(QUEUE_EMAIL, EXCHANGE_DIRECT, EMAIL_ROUTING);

            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                /**
                 *
                 * @param consumerTag  消费者标签
                 * @param envelope     信封，可以获取交换机，路由key，deliveryTag可以用于编程回复
                 * @param properties   文本属性
                 * @param body         信息
                 * @throws IOException
                 */
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String exchange = envelope.getExchange();
                    String routingKey = envelope.getRoutingKey();
                    long deliveryTag = envelope.getDeliveryTag();
                    String message = new String(body, "utf-8");
                    System.out.println("receive message :" + message);
                }
            };

            /**
             * 监听队列String queue, boolean autoAck,Consumer callback
             * 参数明细
             * 1、队列名称
             * 2、是否自动回复，设置为true为表示消息接收到自动向mq回复接收到了，mq接收到回复会删除消息，设置
             为false则需要手动回复
             * 3、消费消息的方法，消费者接收到消息后调用此方法
             */
            channel.basicConsume(QUEUE_EMAIL, true, defaultConsumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
