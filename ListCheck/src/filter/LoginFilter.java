package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Object username = request.getSession().getAttribute("username");
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("/CheckCodeServlet") || uri.contains("/LoginServlet") || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/js/")) {
            chain.doFilter(request, resp);
        } else {
            if (username != null) {
                chain.doFilter(request, resp);
            } else {
                request.setAttribute("login_error", "你尚未登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
