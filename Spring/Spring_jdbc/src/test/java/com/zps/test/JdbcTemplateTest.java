package com.zps.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {


    @Test
    public void test02() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jt = (JdbcTemplate) app.getBean("jdbcTemplate");


        int a = jt.update("insert into account values(?,?)", "zhangsan", 1000);
        System.out.println(a);
    }


    @Test
    /**
     * 测试手动jdbc
     */
    public void test01() throws PropertyVetoException {

        JdbcTemplate jt = new JdbcTemplate();
        ComboPooledDataSource c = new ComboPooledDataSource();
        c.setDriverClass("com.mysql.jdbc.Driver");
        c.setJdbcUrl("jdbc:mysql://localhost:3306/db?useUnicode=true&characterEncoding=UTF-8");
        c.setUser("root");
        c.setPassword("16436130");
        jt.setDataSource(c);
        int a = jt.update("insert into account values(?,?)", "张三", 1000);
        System.out.println(a);
    }
}
