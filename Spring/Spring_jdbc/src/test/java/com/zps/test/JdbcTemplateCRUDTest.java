package com.zps.test;

import com.zps.domain.account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jt;


    @Test
    public void test02() {

        Integer i = jt.queryForObject("select count(*) from account", Integer.class);
        System.out.println(i);
    }

    //查询单个
    @Test
    public void test01() {

        List<account> list = jt.query("select * from account", new BeanPropertyRowMapper<account>(account.class));
        System.out.println(list);
    }

    @Test
    public void test() {
        // jt.update("update account set money=? where name = ?",10000,"zhangsan");
        jt.update("delete from account where name = ?", "zhangsan");
    }
}
