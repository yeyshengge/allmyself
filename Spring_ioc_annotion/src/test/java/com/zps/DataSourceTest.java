package com.zps;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.java.util.jar.pack.DriverResource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.ResourceBundle;

public class DataSourceTest {


    @Test
    //c3p0连接数据库（spring抽取配置文件）
    public void Test4() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource c = (DataSource) app.getBean("dataSource");
        Connection conn = c.getConnection();
        System.out.println(conn);
        conn.close();
    }


    @Test
    //c3p0连接数据库（抽取配置文件）
    public void Test03() throws Exception {
        /*//properties获取配置文件
        Properties p = new Properties();
        InputStream is = DataSourceTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        p.load(is);
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        String url = p.getProperty("url");
        String driver = p.getProperty("driver");*/
        //ResourceBundle加载
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String username = rb.getString("username");
        String password = rb.getString("password");
        String url = rb.getString("url");
        String driver = rb.getString("driver");

        ComboPooledDataSource cd = new ComboPooledDataSource();
        cd.setDriverClass(driver);
        cd.setUser(username);
        cd.setPassword(password);
        cd.setJdbcUrl(url);
        Connection conn = cd.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    //c3p0连接数据库
    public void Test01() throws Exception {
        ComboPooledDataSource cp = new ComboPooledDataSource();
        cp.setDriverClass("com.mysql.jdbc.Driver");
        cp.setJdbcUrl("jdbc:mysql://localhost:3306/travel");
        cp.setUser("root");
        cp.setPassword("16436130");
        Connection conn = cp.getConnection();
        conn.close();
        System.out.println(conn);
    }

    @Test
    //Druid连接池连接数据库
    public void Test02() throws Exception {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("16436130");
        ds.setUrl("jdbc:mysql://localhost:3306/travel");
        DruidPooledConnection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
