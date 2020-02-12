package com.zps;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * SpringBootApplication声明是springboot的主程序，说明是个spring容器
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) {
        //服务启动
        SpringApplication.run(SpringBootApplication.class, args);
    }
}
