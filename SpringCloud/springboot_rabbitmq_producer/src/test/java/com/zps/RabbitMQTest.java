package com.zps;

import com.zps.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test1() {
        /**
         * 参数一：交换机名称
         * 参数二:路由key
         * 参数三:传输的信息
         */
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, "item.add", "增加商品 item.add");
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, "item.update", "修改商品 item.update");
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, "item.delete", "删除商品 item.delete");
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, "test.item.delete", "测试 test.item.delete");
    }

    /**
     * 测试ConfirmsCallback()回调函数，检测producer到exchange直接是否丢失
     * 在测试方法中进行测试，当测试方法结束，rabbitmq相关的资源也就关闭了，
     * 虽然我们的消息发送出去，但异步的ConfirmCallback却由于资源关闭而出现了上面的问题
     */
    @Test
    public void testConfirmsCallback() throws InterruptedException {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * @param correlationData  相关信息
             * @param ack       是否成功
             * @param s        错误信息
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String s) {
                if (ack) {
                    //传输成功
                    System.out.println("传输成功" + s);
                } else {
                    //传输失败
                    System.out.println("传输失败" + s);
                }
            }
        });

        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, "info", "发送信息");
        //在测试方法中进行测试，当测试方法结束，rabbitmq相关的资源也就关闭了，
        //虽然我们的消息发送出去，但异步的ConfirmCallback却由于资源关闭而出现了上面的问题
        Thread.sleep(2000);
    }

    @Test
    public void testReturnCallback() throws Exception {
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             * @param message       消息数据
             * @param replyCode     状态码
             * @param replyText     返回信息
             * @param exchange      交换机信息
             * @param routingKey    路由key
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                System.out.println("message:" + message);
                System.out.println("replyCode:" + replyCode);
                System.out.println("replyText:" + replyText);
                System.out.println("exchange:" + exchange);
                System.out.println("routingKey:" + routingKey);
            }
        });

        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, "info", "发送信息two");
        //在测试方法中进行测试，当测试方法结束，rabbitmq相关的资源也就关闭了，
        //虽然我们的消息发送出去，但异步的ConfirmCallback却由于资源关闭而出现了上面的问题
        Thread.sleep(2000);

    }

    @Test
    public void testSend() throws Exception {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, "info", "发送信息" + i);
        }
    }

    //测试TTL队列存活时间
    @Test
    public void testTTL() throws Exception {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE_TTL, "info", "发送信息");
        }
    }

    //测试TTL单个信息存活时间
    @Test
    public void testTTL01() throws Exception {
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE_TTL, "info", "发送信息", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("10000");
                return message;
            }
        });
    }


    //测试死信
    @Test
    public void testDLX() throws Exception {
        //测试存活时间
        //rabbitTemplate.convertAndSend("topic_test", "test.hehe", "发送信息,我会在时间外过时");
        //测试maxLength
        /*for (int i = 0; i <20; i++) {
            rabbitTemplate.convertAndSend("topic_test", "test.hehe", "发送信息,我会在超过最大数"+i);
        }*/
        //测试拒收
        rabbitTemplate.convertAndSend("topic_test", "test.hehe", "发送信息,我会被拒收");
        while (true){

        }
    }
}
