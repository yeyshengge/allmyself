package com.zps.springboot_03_datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@MapperScan("com.zps.mapper") mybatis的扫描
@MapperScan("com.zps.springboot_03_datasource.mapper") //通用mapper的扫描
public class Springboot03DatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03DatasourceApplication.class, args);
    }

}
