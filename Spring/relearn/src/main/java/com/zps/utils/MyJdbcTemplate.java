package com.zps.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyJdbcTemplate {

    private DataSource dataSource;

    public MyJdbcTemplate() {

    }

    public MyJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int updata(String sql, Object... args) {
        Connection conn = null;
        int index = 0;
        try {
            conn = dataSource.getConnection();
            String[] split = sql.split("\\?");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                if (i < split.length - 1) {
                    sb.append(split[i] + " " + args[i]);
                } else {
                    sb.append(split[i]);
                }
            }
            Statement state = conn.createStatement();
            index = state.executeUpdate(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }

    public <T> List<T> query(String sql, BeanPropertyRowMapper<T> rowMapper, Object... args) {
        Connection conn = null;
        int index = 0;
        List<T> list = new ArrayList<T>();
        try {
            conn = dataSource.getConnection();
            String[] split = sql.split("\\?");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                if (i < split.length - 1) {
                    sb.append(split[i] + " " + args[i]);
                } else {
                    sb.append(split[i]);
                }
            }
            Statement state = conn.createStatement();
            ResultSet resultSet = state.executeQuery(sb.toString());

            while (resultSet.next()) {
                int row = resultSet.getRow();
                T t = rowMapper.mapRow(resultSet, row);
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public <T> T queryForObject(String sql, BeanPropertyRowMapper<T> rowMapper, Object... args) {

        return this.query(sql, rowMapper, args).get(0);
    }


    public static void main(String[] args) {
        MyJdbcTemplate myJdbcTemplate = new MyJdbcTemplate();
    }

}
