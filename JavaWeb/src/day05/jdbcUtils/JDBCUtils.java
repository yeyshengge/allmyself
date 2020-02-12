package day05.jdbcUtils;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String url;
    private static String user;
    private static String pswd;
    private static String driver;
    static {
        /*
        user=root
        password=16436130
        url=jdbc:mysql://localhost:3306/test01
        driver=com.mysql.jdbc.Driver
         */

        try {
            Properties prop = new Properties();
           /* ClassLoader c = JDBCUtils.class.getClassLoader();
            URL resource = c.getResource("jdbc.properties");
            String path = resource.getPath();
            System.out.println(path);*/

            FileReader fr = new FileReader("D:\\ideaspacework\\JavaWeb\\src\\day05\\jdbcUtils\\jdbc.properties");

            prop.load(fr);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            pswd = prop.getProperty("password");
            driver = prop.getProperty("driver");

            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {


            return DriverManager.getConnection(url,user,pswd);
    }
    public static void close(Connection conn, Statement stmt){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
