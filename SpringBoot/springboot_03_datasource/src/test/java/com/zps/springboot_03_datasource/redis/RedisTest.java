package com.zps.springboot_03_datasource.redis;

import com.zps.springboot_03_datasource.pojo.User;
import com.zps.springboot_03_datasource.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        //基本数据类型
        redisTemplate.boundValueOps("username").set("lisi");
        Object username = redisTemplate.boundValueOps("username").get();
        System.out.println(username);
        //map散列
        redisTemplate.boundHashOps("user").put("username", "zhangsan");
        redisTemplate.boundHashOps("user").put("age", "18");
        Set set = redisTemplate.boundHashOps("user").keys();
        System.out.println("hash散列键名 = " + set);
        List list = redisTemplate.boundHashOps("user").values();
        System.out.println("hash散列值" + list);
        //list序列
        redisTemplate.boundListOps("animals").leftPush("cat");
        redisTemplate.boundListOps("animals").leftPush("dog");
        redisTemplate.boundListOps("animals").leftPush("pig");
        System.out.println("list序列" + redisTemplate.boundListOps("animals").range(0, -1));
        //set集合
        redisTemplate.boundSetOps("test").add("aaa", "bbb", "ccc");
        System.out.println(redisTemplate.boundSetOps("test").members());
        //sort有序排序
        redisTemplate.boundZSetOps("score").add("chinese", 90);
        redisTemplate.boundZSetOps("score").add("math", 80);
        redisTemplate.boundZSetOps("score").add("english", 99);
        System.out.println(redisTemplate.boundZSetOps("score").range(0, -1));
    }
}