package day05.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
查询表中数据，并且遍历
 */
public class JdbcDemo06 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();
        Account a = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "16436130");
            stmt = conn.createStatement();
            String str = "Select * from account";
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                //rs.next();          //默认是标题行，使用next向下读取一行
                int id = rs.getInt(1);     //getXxx()  Xxx代表类型，括号里可以填索引(从1开始)跟字符串(列名)
                String name = rs.getString("name");
                int balance = rs.getInt(3);
                a=new Account();
                a.setId(id);
                a.setName(name);
                a.setBalance(balance);
                list.add(a);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (!(rs == null)) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (!(stmt == null)) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (!(conn == null)) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(list);
    }
}
