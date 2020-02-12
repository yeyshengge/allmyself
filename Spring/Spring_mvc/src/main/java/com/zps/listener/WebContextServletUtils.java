package com.zps.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class WebContextServletUtils {

    public static ApplicationContext getApplicationContext(ServletContext servletContext) {

        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
