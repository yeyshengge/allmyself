package day05.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/*
jdbc预览
 */

public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //导入驱动jar包
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "16436130");
        //定义sql语句
        String str = "update account set balance = 500 where id=1";
        //获取执行对象statement
        Statement stmt = conn.createStatement();
        //执行sql
        int i = stmt.executeUpdate(str);
        //处理结果
        System.out.println(i);
        //释放资源
        stmt.close();
        conn.close();
    }
}
