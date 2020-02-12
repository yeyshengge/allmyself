package day14;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletReqHeader")
public class ServletReqHeader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String value = request.getHeader(s);
            System.out.println(s + "----" + value);
        }
        System.out.println("------");
        String header = request.getHeader("user-agent");
        if (header.contains("Chrome")) {
            System.out.println("谷歌访问的");
        } else if (header.contains("Gecko")) {
            System.out.println("ie来了");
        }


    }
}
