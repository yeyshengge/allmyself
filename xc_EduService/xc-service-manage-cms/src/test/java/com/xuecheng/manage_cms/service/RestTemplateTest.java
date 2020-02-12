package com.xuecheng.manage_cms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

/**
 * Created by zps on 2019/12/30 16:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {


    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {
        /**
         * 第一个参数为请求连接
         * 第二个参数为返回类型
         */
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        //获取数据
        Map body = forEntity.getBody();

        Set set = body.keySet();
        for (Object o : set) {
            System.out.println(o + "---" + body.get(o));
        }


    }
}
