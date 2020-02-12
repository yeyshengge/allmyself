package com.zps.springboot_03_datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//@Configuration
//@PropertySource("jdbc.properties")
//@EnableConfigurationProperties(JdbcProperties.class)
public class ApplicationConfig {

    /*
        @Value("${jdbc.driver}")
        String driver;
        @Value("${jdbc.username}")
        String username;
        @Value("${jdbc.password}")
        String password;
        @Value("${jdbc.url}")
        String url;


        @Bean
        public DataSource getDataSource() {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setUrl(url);
            return dataSource;
        }*/
  /*  @Bean
    public DataSource getDataSource(JdbcProperties jdbcProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcProperties.getDriver());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setPassword(jdbcProperties.getPassword());
        dataSource.setUrl(jdbcProperties.getUrl());
        return dataSource;*/

   /* @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource getDataSource() {
        return new DruidDataSource();

    }*/
}
