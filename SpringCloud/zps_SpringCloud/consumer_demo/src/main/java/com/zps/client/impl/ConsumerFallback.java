package com.zps.client.impl;

import com.zps.client.ConsumerClient;
import com.zps.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class ConsumerFallback implements ConsumerClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("请求异常");
        return user;
    }
}
