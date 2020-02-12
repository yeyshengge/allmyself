package day06.druidutils;

import javax.sql.DataSource;
import java.sql.*;

public class UseUtils {
    public static void main(String[] args) throws SQLException {
        DataSource ds = JDBCUtils.getDataSource();
        Connection conn = JDBCUtils.getConnection();
        //Connection conn = ds.getConnection();
        String str = "insert into account (name,balance) values(?,?)";

        PreparedStatement pstmt = conn.prepareStatement(str);
        pstmt.setString(1, "王八达");
        pstmt.setInt(2, 200);
        int a = pstmt.executeUpdate();
        System.out.println(a);
        JDBCUtils.close(pstmt, conn);

    }
}
