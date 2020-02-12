package com.zps;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zps.dao.UserMapper;
import com.zps.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserMapperTest {


    @Test
    public void test02() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = sqlSessionFactoryBuilder.build(resourceAsStream).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1, 3);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println(pageInfo.getTotal());


    }


    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSession sqlSession = sqlSessionFactoryBuilder.build(resourceAsStream).openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setUsername("Tom");
        user.setPassword("123456");
        user.setBirthday(new Date());
        mapper.save(user);
        sqlSession.close();
    }
}
