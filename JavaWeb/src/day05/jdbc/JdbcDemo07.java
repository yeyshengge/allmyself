package day05.jdbc;

import day05.jdbcUtils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
登陆案例
 */
public class JdbcDemo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = null;
        Statement stat = null;
        ResultSet re = null;
        try {
            System.out.println("请输入用户名：");
            String usrname = sc.nextLine();
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            //System.out.println(usrname);
            //System.out.println(password);
            conn = JDBCUtils.getConnection();
            stat = conn.createStatement();
            // 创建一张user表
            //String s = "create table user(username varchar(20),password varchar(20))";
            //添加数据
            //String s ="insert into user (username,password) values ('张三','123456'),('赵四','123456')";
            //查询该用户名
            String uname = "select * from user";

            re = stat.executeQuery(uname);
            while (re.next()) {
                String username = re.getString("username");
                String pswd = re.getString("password");
                if (username.equals(usrname)) {
                    if (password.equals(pswd)) {
                        System.out.println("登陆成功");
                        return;
                    }
                    if (!password.equals(pswd)) {
                        System.out.println("密码错误");
                        return;
                    }
                }
            }
            System.out.println("用户名错误");

            //int i = stat.executeUpdate(s);
            //System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn, stat, re);
        }
    }
}
