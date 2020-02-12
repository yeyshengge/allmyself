package day05.jdbcUtils;

import java.sql.*;

/*
查询表中数据，并且遍历
 */
public class JdbcDemo07 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String str = "Select * from account";
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                //rs.next();          //默认是标题行，使用next向下读取一行
                int id = rs.getInt(1);     //getXxx()  Xxx代表类型，括号里可以填索引(从1开始)跟字符串(列名)
                String name = rs.getString("name");
                int balance = rs.getInt(3);
                System.out.println(id+name+balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.close(conn,stmt,rs);
    }
}
