package day19.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
具体资源路径： /index.jsp       只有访问该资源时，过滤器才会执行
拦截目录： /user/*              访问/user下的资源时，过滤器都会执行
后缀名拦截 ： *.jsp             访问后缀名为jsp时，过滤器才会执行
拦截所有资源 /*                 访问所有资源时，过滤器才会执行
 */


//@WebFilter("/jsp/*")
public class MyFilter02 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器执行了");
        chain.doFilter(req, resp);
        System.out.println("执行完了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
