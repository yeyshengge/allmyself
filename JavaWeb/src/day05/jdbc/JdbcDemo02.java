package day05.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
增删改的练习
 */
public class JdbcDemo02 {
    public static void main(String[] args) {
        //导入驱动jar包

        //获取数据库连接对象
        Connection conn = null;
        Statement stmt = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "16436130");
            //定义sql语句
            //修改一条数据
            //String str = "update account set balance = 500 where id=2";
            //增加数据
            String str = "insert into account (id,name,balance) values (3,'刘六',1000),(4,'王五',2000)";
            //删除数据
            //String str = "delete from account where id=3";
            //获取执行对象statement
            stmt = conn.createStatement();
            //执行sql
            int i = stmt.executeUpdate(str);
            //处理结果
            System.out.println(i);
            //释放资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //判断空指针异常
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
    }
}
