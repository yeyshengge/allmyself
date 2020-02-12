package day16.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AnliServlet01")
public class AnliServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("msg")) {
                flag = true;
                String values=cookie.getValue();
                values=URLDecoder.decode(values,"utf-8");
                response.getWriter().write("欢迎回来,上一次访问时间为："+values);

                Date date = new Date();
                String format = sdf.format(date);
                format= URLEncoder.encode(format,"utf-8");//编码
                cookie.setValue(format);

            }    cookie.setMaxAge(1000);
            response.addCookie(cookie);
            break;
        }
        if (flag == false) {
            response.getWriter().write("第一次访问");

            Date date = new Date();
            String format = sdf.format(date);
            format= URLEncoder.encode(format,"utf-8");//编码
            Cookie cookie = new Cookie("msg",format);
            cookie.setMaxAge(10000);
            response.addCookie(cookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
