package com.zps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

//添加开启Eureka客户端发现的注解
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.zps.mapper")//通用mapper扫描
public class HttpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpDemoApplication.class, args);
    }
}
