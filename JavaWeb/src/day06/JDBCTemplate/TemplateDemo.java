package day06.JDBCTemplate;

import day06.druidutils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;


public class TemplateDemo {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update account set balance = ? where id=? ";
        int count = jt.update(sql, 5000, 2);
        System.out.println(count);
    }
}
