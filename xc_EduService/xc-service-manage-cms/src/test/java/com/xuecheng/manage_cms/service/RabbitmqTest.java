package com.xuecheng.manage_cms.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.xuecheng.manage_cms.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zps on 2019/12/30 16:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitmqTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void test(){

        rabbitTemplate.convertAndSend(RabbitmqConfig.EX_ROUTING_CMS_POSTPAGE, "5a751fab6abb5044e0d19ea1", "message");



    }
}
