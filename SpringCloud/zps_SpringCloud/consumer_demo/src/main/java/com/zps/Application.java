package com.zps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*@SpringBootApplication
@EnableDiscoveryClient//开启客户端发现功能
@EnableCircuitBreaker//开启熔断*/
@SpringCloudApplication //相当于上面三个注解
@EnableFeignClients//标注开启Feign组件
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //注入RestTemplate，用来远程调用
    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
