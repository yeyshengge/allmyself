package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.IndexDaoInter;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class IndexDaoImpl implements IndexDaoInter {

    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Route> queryThemeByName(String str) {
        String sql = "select * from tab_route where rname like ? limit 0,4";
        List<Route> list = jt.query(sql, new BeanPropertyRowMapper<>(Route.class), "%" + str + "%");
        return list;
    }

    @Override
    public List<Route> queryNew() {
        String sql = "select * from tab_route ORDER BY rdate desc limit 0,4";
        List<Route> list = jt.query(sql, new BeanPropertyRowMapper<>(Route.class));
        return list;
    }
}
