package day23.anli.dao.impl;

import day23.anli.dao.LoadDao;
import day23.anli.domain.Province;
import day23.anli.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class LoadDaoImpl implements LoadDao {

    @Override
    public List load() {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from province";
        List<Province> list = jt.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
