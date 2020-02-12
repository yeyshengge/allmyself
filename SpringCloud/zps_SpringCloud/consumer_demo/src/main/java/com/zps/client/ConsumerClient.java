package com.zps.client;

import com.zps.client.impl.ConsumerFallback;
import com.zps.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service",fallback = ConsumerFallback.class)//设置服务名称，不要加斜杆
public interface ConsumerClient {

    //http://user-service/user/1
    @RequestMapping("/user/{id}")
    User findById(@PathVariable Long id);

}
