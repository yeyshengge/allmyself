package com.xuecheng.test.freemarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zps on 2019/12/28 20:14
 */
@SpringBootApplication
public class FreeMarkerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FreeMarkerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
