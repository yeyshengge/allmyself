package com.zps.jobs;

import com.zps.constant.MessageConstant;
import com.zps.constant.RedisConstant;
import com.zps.utils.ALiFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.Set;

public class ClearImgJob {
    @Autowired
    private JedisPool jedisPool;

    public void clearImg() {
        //sdiff()可以实实现两个set集合的差，并且封装在一个新的set集合中
        Set<String> sdiff = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        if (sdiff != null) {
            for (String imgFileName : sdiff) {
                //从服务器上删除
                ALiFileUtils.delete(imgFileName);
                //从缓存中删除
                jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES, imgFileName);
            }
        }
    }
}
