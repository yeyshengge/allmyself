package com.zps;

import com.zps.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

public class Test {

    @org.junit.Test
    public void Test05() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        User user = sqlSession.selectOne("userMapper.findByOne", 1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 删除操作
     *
     * @throws IOException
     */
    @org.junit.Test
    public void Test04() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        sqlSession.delete("userMapper.deleteUser", 5);
        sqlSession.commit();
    }

    /**
     * 修改操作
     *
     * @throws IOException
     */
    @org.junit.Test
    public void Test03() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        sqlSession.update("userMapper.updateUser", new User(4, "王麻子", "111111"));
        sqlSession.commit();
    }

    /**
     * 增加操作
     *
     * @throws IOException
     */
    @org.junit.Test
    public void Test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        sqlSession.insert("userMapper.insertUser", new User(5, "zhangsan", "123456"));
        sqlSession.commit();
    }

    /**
     * 查询操作
     *
     * @throws IOException
     */
    @org.junit.Test
    public void Test01() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取sqlSession工厂对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactoryBuilder.build(resourceAsStream).openSession();
        //执行sql语句
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印输出
        System.out.println(userList);
        //释放资源
        sqlSession.close();

    }


}
