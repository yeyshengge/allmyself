package com.zps.dao.impl;

import com.zps.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private DataSource dataSource;


    @Override
    public void save() {
        System.out.println("执行了");
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
