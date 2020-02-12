package com.zps.dao.impl;

import com.zps.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;

    public void send(String sendMan, double money) {
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = dataSource.getConnection();
            prep = conn.prepareStatement("update account set money = money-? where name = ?");
            prep.setObject(1, money);
            prep.setObject(2, sendMan);
            prep.executeUpdate();
        } catch (Exception e) {

        } finally {
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void recive(String recMan, double money) {
        Connection conn = null;
        PreparedStatement prep = null;
        try {
            conn = dataSource.getConnection();
            prep = conn.prepareStatement("update account set money = money+? where name = ?");
            prep.setObject(1, money);
            prep.setObject(2, recMan);
            prep.executeUpdate();
        } catch (Exception e) {

        } finally {
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
