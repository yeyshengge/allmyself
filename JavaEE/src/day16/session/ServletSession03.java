package day16.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@WebServlet("/ServletSession03")
public class ServletSession03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取HttpSession
        HttpSession session = request.getSession();
        //拿到信息
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
        Enumeration<URL> servletSession03 = ServletSession03.class.getClassLoader().getResources("ServletSession03");
        System.out.println(servletSession03);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
