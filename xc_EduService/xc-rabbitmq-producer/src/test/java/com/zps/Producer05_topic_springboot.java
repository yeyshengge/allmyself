package com.zps;


import com.zps.config.ProducerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zps on 2020/1/2 19:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Producer05_topic_springboot {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testRabbit() {
        String message = "message to email";
        rabbitTemplate.convertAndSend(ProducerConfig.EXCHANGE_TOPIC, "info.email.sms", message);
        System.out.println(message);
    }
}
