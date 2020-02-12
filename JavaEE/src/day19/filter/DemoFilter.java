package day19.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Scanner;


//@WebFilter(value = "/*", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class DemoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("Filter开始执行了");
        chain.doFilter(req, resp);
        System.out.println("Filter执行完成了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
