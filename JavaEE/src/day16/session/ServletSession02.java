package day16.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletSession02")
public class ServletSession02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取HttpSession
        HttpSession session = request.getSession();
        //拿到信息
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
        Cookie c= new Cookie("JSESSIONID",session.getId());
        String value = c.getValue();
        System.out.println("==="+value);
        c.setMaxAge(60*60);
        response.addCookie(c);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
