package com.zps.jobs;

import com.zps.constant.RedisConstant;
import com.zps.utils.ALiFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Component
public class updateMember {
    @Autowired
    private JedisPool jedisPool;

    @Scheduled(cron = "* * * * * ?")
    public void update() {
        System.out.println("a");
    }
}
