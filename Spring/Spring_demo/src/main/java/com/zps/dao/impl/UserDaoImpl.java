package com.zps.dao.impl;

import com.zps.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from emp", Integer.class);
        System.out.println(count);
    }
}
