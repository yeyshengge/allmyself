package day19.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/jsp/anli.jsp")
public class Filter001 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("001执行了");
        chain.doFilter(req, resp);
        System.out.println("001执行完了");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
