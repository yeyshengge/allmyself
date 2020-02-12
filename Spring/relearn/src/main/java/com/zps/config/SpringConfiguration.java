package com.zps.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.zps")
@Import(DataSourcesConfiguration.class)
public class SpringConfiguration {

}
