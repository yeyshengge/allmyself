package com.zps.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by zps on 2020/1/5 14:19
 */
//@Component
public class ConsumerListener implements ChannelAwareMessageListener {
    @Override
    //@RabbitListener(queues = "DIRECT_QUEUE")
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println(new String(message.getBody()));
            System.out.println("执行业务方法");
            Thread.sleep(2000);
            /*   int i = 0/0;*/
            //没有报错执行签收long deliveryTag, boolean multiple 一次接受多条信息
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            //报错，拒绝签收，
            /**
             * long deliveryTag,     标志
             * boolean multiple,     一次接受多条信息
             * boolean requeue       是否重回队列
             */
            channel.basicNack(deliveryTag, true, true);
        }

    }
}
