package day06.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/*
5. Druid：数据库连接池实现技术，由阿里巴巴提供的
		1. 步骤：
			1. 导入jar包 druid-1.0.9.jar
			2. 定义配置文件：
				* 是properties形式的
				* 可以叫任意名称，可以放在任意目录下
			3. 加载配置文件。Properties
			4. 获取数据库连接池对象：通过工厂来来获取  DruidDataSourceFactory
			5. 获取连接：getConnection
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();

        InputStream re = Demo01.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(re);
        re.close();
        //DruidDataSourceFactory工厂类中有一个人createDataSource
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
