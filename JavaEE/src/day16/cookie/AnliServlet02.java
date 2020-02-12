package day16.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AnliServlet02")
public class AnliServlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset:utf-8");
        request.setCharacterEncoding("utf-8");
        Cookie[] cookies = request.getCookies();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd　hh:mm:ss");
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getValue().equals("time")) {
                    //不是第一次访问；
                    flag = true;
                    String value = cookie.getValue();
                    response.getWriter().write("欢迎回来，上一次访问时间为：" + value);
                    Date d = new Date();
                    String format = sdf.format(d);
                    cookie.setValue(format);
                    cookie.setMaxAge(111111111);
                }
                response.addCookie(cookie);
            }
        }

        if (false == false) {
            //是第一次访问
            response.getWriter().write("第一次访问");

            Date d = new Date();
            String format = sdf.format(d);
            Cookie cookie = new Cookie("msg", format);
            cookie.setMaxAge(10000);
            response.addCookie(cookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
