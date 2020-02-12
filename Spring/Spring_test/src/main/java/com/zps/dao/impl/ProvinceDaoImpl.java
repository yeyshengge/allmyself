package com.zps.dao.impl;

import com.zps.dao.ProvinceDao;
import com.zps.domain.City;
import com.zps.domain.Part;
import com.zps.domain.Province;
import com.zps.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<City> chang(String value) {
        String sql = "select * from  province where username=?";
        Province province = jt.queryForObject(sql, new BeanPropertyRowMapper<Province>(Province.class), value);
        //System.out.println(province);
        int id = province.getId();
        String sql2 = "select * from city where p_id=?";
        List<City> l = jt.query(sql2, new BeanPropertyRowMapper<>(City.class), id);
        return l;

    }

    @Override
    public List<Part> city(String city) {
        String sql = "select * from  city where name=?";
        City c = jt.queryForObject(sql, new BeanPropertyRowMapper<City>(City.class), city);
        String sql2 = "select * from part where x_id = ? ";
        List<Part> query = jt.query(sql2, new BeanPropertyRowMapper<Part>(Part.class), c.getId());
        return query;
    }
}
