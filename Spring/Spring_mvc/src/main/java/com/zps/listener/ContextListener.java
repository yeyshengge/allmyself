package com.zps.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //创建一个上下文对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        //在web.xml中获取applicationConfig对应的值，该值即为配置文件名称
        String applicationConfig = servletContext.getInitParameter("applicationConfig");
        ApplicationContext app = new ClassPathXmlApplicationContext(applicationConfig);
        servletContext.setAttribute("app", app);
        System.out.println("初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
