package com.zps.dao.impl;

import com.zps.dao.UserDao;
import com.zps.domain.User;
import com.zps.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private  JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public User find(String username, String password) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("select * from user where username = ? and password = ?", new BeanPropertyRowMapper<>(User.class), username, password);
        } catch (Exception e) {

        }
        return user;
    }
}
