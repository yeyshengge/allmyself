package com.zps.rabbitmq.routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zps.utils.SimpleRabbitMQUtil;

/**
 * 路由：生产者
 */
public class Producer {

    //声明交换机
    public static final String ROUTING = "ROUTING";
    //声明列队一
    public static final String QUEUE_NAME_INSERT = "queue_name_insert";
    //声明列队二
    public static final String QUEUE_NAME_UPDATE = "queue_name_update";


    public static void main(String[] args) throws Exception {

        //1. 创建一个连接工厂
        //2. 创建连接
        Connection connection = SimpleRabbitMQUtil.getConnection();
        //3. 创建频道
        Channel channel = connection.createChannel();
        /**声明交换机
         *参数一:交换机名称
         * 参数二:交换机类型
         */
        channel.exchangeDeclare(ROUTING, BuiltinExchangeType.DIRECT);
        //4. 声明队列；
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列（消息会持久化保存在服务器上）
         * 参数3：是否独占本连接
         * 参数4：是否在不使用的时候队列自动删除
         * 参数5：其它参数
         */
        channel.queueDeclare(QUEUE_NAME_INSERT, true, false, false, null);
        channel.queueDeclare(QUEUE_NAME_UPDATE, true, false, false, null);

        /**
         * 列队绑定
         *参数一：列队名称
         *参数二：交换机名称
         *参数三：路由key
         */
        channel.queueBind(QUEUE_NAME_UPDATE, ROUTING, "update");
        channel.queueBind(QUEUE_NAME_INSERT, ROUTING, "insert");
        //5. 发送信息
        String message = "hello RabbitMQ 路由insert !";
        /**
         * 参数1：交换机名称；如果没有则指定空字符串（表示使用默认的交换机）
         * 参数2：路由key，简单模式中可以使用队列名称
         * 参数3：消息其它属性
         * 参数4：消息内容
         */
        channel.basicPublish(ROUTING, "insert", null, message.getBytes());

        message = "hello RabbitMQ 路由update !";
        /**
         * 参数1：交换机名称；如果没有则指定空字符串（表示使用默认的交换机）
         * 参数2：路由key，简单模式中可以使用队列名称
         * 参数3：消息其它属性
         * 参数4：消息内容
         */
        channel.basicPublish(ROUTING, "update", null, message.getBytes());
        System.out.println("已发送信息 = " + message);

        //6. 关闭资源
        channel.close();
        connection.close();
    }


}
