package day15;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo06")
public class ServletDemo06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取ServletContext对象
        ServletContext context= request.getServletContext();

        //配置文件在根目录下
        String b = context.getRealPath("/b.txt");
        System.out.println(b);//D:\ideaspacework\JavaWeb\out\artifacts\JavaEE_war_exploded\b.txt

        //配置文件在WEB-INF目录下
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);//

        //配置文件在Src目录下
        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);//D:\ideaspacework\JavaWeb\out\artifacts\JavaEE_war_exploded\WEB-INF\classes\a.txt

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
