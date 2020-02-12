package KaoShi;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws SQLException {

        Connection conn = JDBCUtils.getConnection();


        String sql = " select * from emp where (2019-YEAR(hiredate)) >35";

    }

}
