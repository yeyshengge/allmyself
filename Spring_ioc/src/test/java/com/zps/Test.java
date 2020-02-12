package com.zps;

import com.zps.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    //测试scope
    public void Demo01() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDao = (UserDaoImpl) app.getBean("userDao");
        UserDaoImpl userDao2 = (UserDaoImpl) app.getBean("userDao");
        System.out.println(userDao);
        System.out.println(userDao2);
    }

    @org.junit.Test
    //测试scope
    public void Demo02() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDao = (UserDaoImpl) app.getBean("userDao");
        System.out.println(userDao);
        app.close();

    }


    @org.junit.Test
    //测试静态工厂
    public void Demo03() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDaoImpl userDao = (UserDaoImpl) app.getBean("userDao");
        System.out.println(userDao);
    }
}
