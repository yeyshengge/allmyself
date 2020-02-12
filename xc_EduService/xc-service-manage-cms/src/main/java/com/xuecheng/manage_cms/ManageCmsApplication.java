package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zps on 2019/12/20 18:40
 */
@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms") //扫描model模块下的cms包
@ComponentScan(basePackages = {"com.xuecheng.api"})  //扫描接口
@ComponentScan(basePackages = {"com.xuecheng.manage_cms"}) //扫描本包下的类
@ComponentScan(basePackages = {"com.xuecheng.framework"})//扫描common下的包
public class ManageCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class, args);
    }

    //注入restTemplate
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
