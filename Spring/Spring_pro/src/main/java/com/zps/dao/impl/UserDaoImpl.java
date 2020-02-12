package com.zps.dao.impl;

import com.zps.dao.UserDao;
import com.zps.domain.Role;
import com.zps.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> list() {
        List<User> list = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public List<Role> findById(Long id) {
        return jdbcTemplate.query("select * from sys_role r,sys_user_role ur where ur.roleId = r.id and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
    }

    @Override
    public Long save(final User user) {
        PreparedStatementCreator p = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement prep = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                prep.setObject(1, null);
                prep.setObject(2, user.getUsername());
                prep.setObject(3, user.getEmail());
                prep.setObject(4, user.getPassword());
                prep.setObject(5, user.getPhoneNum());
                return prep;
            }
        };

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(p, keyHolder);
        long l = keyHolder.getKey().longValue();
        //jdbcTemplate.update("insert into sys_user values (?,?,?,?,?)", null, user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());
        return l;
    }

    @Override
    public void saveUidAndRid(Long index, Long[] roles) {
        for (Long role : roles) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)", index, role);
        }
    }

    @Override
    public void remove(int id) {
        jdbcTemplate.update("delete  from sys_user_role where userId = ?",id);
        jdbcTemplate.update("delete from sys_user where id =?" ,id);
    }
}
