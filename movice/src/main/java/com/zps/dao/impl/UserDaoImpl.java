package com.zps.dao.impl;

import com.zps.dao.UserDao;
import com.zps.domain.User;
import com.zps.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User registe(String username, String password) {
        User user = null;
        try {
            String sql = "select * from user where username = ?";
            user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }
        return user;
    }

    @Override
    public void save(String username, String password) {
        String sql = "insert into user (id,username,password) values (null,?,?)";
        jt.update(sql, username, password);
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        try {
            String sql = "select * from user where username = ? and password =?";
            user = jt.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {

        }
        return user;
    }
}
