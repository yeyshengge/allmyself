package day22.Registr_Ajax;


import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

public class CheckUserDao {


    public boolean checkuser(String username) {
        try {
            JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
            String sql = "select * from user where name = ?";
            Map<String, Object> map = jt.queryForMap(sql, username);
            return true;
        } catch (Exception e) {
            return false;
        }


        // return true;
    }

}
