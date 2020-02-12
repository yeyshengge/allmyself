package day16.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletCookieDemo04")
public class ServletCookieDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c1 = new Cookie("name", "张三");

        /*
        正数代表持久多少秒
        负数代表默认值，回话结束就删除Cookie
        0代表删除Cookie
         */
        c1.setMaxAge(300);
        //c1.setMaxAge(0);删除Cookie
        // c1.setMaxAge(20);


        response.addCookie(c1);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
