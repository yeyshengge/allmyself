package day06.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        //获取DataSource对象
        DataSource ds = new ComboPooledDataSource();
        //获取连接对象
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
