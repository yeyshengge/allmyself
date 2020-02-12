package day05.jdbc;

import day05.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
登陆案例升级版
 */
public class JdbcDemo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String usrname = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        boolean method = new JdbcDemo08().method(usrname, password);
        System.out.println(method);
    }

    private boolean method(String usrname, String password) {
        Connection conn = null;
        Statement stat = null;
        ResultSet re = null;
        try {
            conn = JDBCUtils.getConnection();
            stat = conn.createStatement();
            // 创建一张user表
            //String s = "create table user(username varchar(20),password varchar(20))";
            //添加数据
            //String s ="insert into user (username,password) values ('张三','123456'),('赵四','123456')";
            //查询该用户名
            String uname = "select * from user where username = '" + usrname + "' and password = '" + password + "'";
            re = stat.executeQuery(uname);
            return re.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, stat, re);
        }
        return false;
    }

}
