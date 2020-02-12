package com.zps.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration

@ComponentScan("com.zps")

@Import(DataSourceConfiguration.class)
public class SpringConfiguration {


}
