package day05.jdbc;

import day05.jdbcUtils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*
因为存在sql注入
登陆案例升级版使用PreparedStatement
 */
public class JdbcDemo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String usrname = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        boolean method = new JdbcDemo09().method(usrname, password);
        System.out.println(method);
    }

    private boolean method(String usrname, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet re = null;
        try {
            conn = JDBCUtils.getConnection();
            //String s = "create table user(username varchar(20),password varchar(20))";
            String str = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(str);
            pstmt.setString(1, usrname);
            pstmt.setString(2, password);
            re = pstmt.executeQuery();
            return re.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, pstmt, re);
        }
        return false;
    }
}
