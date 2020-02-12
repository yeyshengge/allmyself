package com.zps.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zps.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = HelloService.class) //该注释声明的是一个服务
@Transactional
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "hello " + name;
    }
}
