package com.zps.dao.impl;

import com.zps.dao.IndexDao;
import com.zps.domain.Movice;
import com.zps.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class IndexDaoImpl implements IndexDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Movice> findList(int start, int pageSize, String searchName, String kind) {
       // System.out.println("start" + start + ",pagesize" + pageSize + ",sername" + searchName);
        String sql = "";
        if (kind == null || "".equals(kind) || kind.length() < 0) {
            if (searchName == null || "".equals(searchName) || searchName.length() < 0) {
                sql = "select * from movice order by date desc limit ?,? ";
                List<Movice> list = jt.query(sql, new BeanPropertyRowMapper<Movice>(Movice.class), start, pageSize);
              //  System.out.println("查询后list1" + list);
                return list;
            } else {
                sql = "select * from movice where name like ?  order by date desc limit ?,? ";
                List<Movice> list = jt.query(sql, new BeanPropertyRowMapper<Movice>(Movice.class), "%" + searchName + "%", start, pageSize);
                //System.out.println("查询后list2" + list);
                return list;
            }

        } else {
            if (searchName == null || "".equals(searchName) || searchName.length() < 0) {
                sql = "select * from movice where kind like ? order by date desc limit ?,? ";
                List<Movice> list = jt.query(sql, new BeanPropertyRowMapper<Movice>(Movice.class), "%" + kind + "%", start, pageSize);
                //System.out.println("查询后list3" + list);
                return list;
            } else {
                sql = "select * from movice where name like ? and kind like ? order by date desc limit ?,? ";
                List<Movice> list = jt.query(sql, new BeanPropertyRowMapper<Movice>(Movice.class), "%" + searchName + "%", "%" + kind + "%", start, pageSize);
                //System.out.println("查询后list4" + list);
                return list;
            }
        }
    }

    @Override
    public int findCount(int pageSize, String searchName, String kind) {
        String sql = "";
        if (kind == null || "".equals(kind) || kind.length() < 0) {
            if (searchName == null || "".equals(searchName) || searchName.length() < 0) {
                sql = "select count(*) from movice ";
                return jt.queryForObject(sql, Integer.class);

            } else {
                sql = "select count(*) from movice where name like ? ";
                return jt.queryForObject(sql, Integer.class, "%" + searchName + "%");
            }
        } else {
            if (searchName == null || "".equals(searchName) || searchName.length() < 0) {
                sql = "select count(*) from movice where kind like ?  ";
                return jt.queryForObject(sql, Integer.class, "%" + kind + "%");

            } else {
                sql = "select count(*) from movice where name like ? and kind like ? ";
                return jt.queryForObject(sql, Integer.class, "%" + searchName + "%", "%" + kind + "%");
            }
        }


    }

    @Override
    public Movice into(int id) {
        Movice m = null;
        try {
            String sql = "select * from movice where id= ?";
            m = jt.queryForObject(sql, new BeanPropertyRowMapper<Movice>(Movice.class), id);
        } catch (Exception e) {
        }
        return m;
    }
}
