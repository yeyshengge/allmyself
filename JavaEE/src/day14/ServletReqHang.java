package day14;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
   请求行  ：   GET /test/header?username=zhangsan HTTP/1.1
   1,获取请求方式 ：GET
         String getMethod()
   2,获取虚拟目录：  /test
         String getContextPath()
   3,获取servlet路径：/header
         String getServletPath();
   4,获取get方式请求参数 name=zhangsan ;
         String getRequestString()
   5,获取请求URI : /test/header
         String getRequestURI    返回的是/test/header
         StringBuffer getRequestURL()   返回的是Http://localhost/test/header
   6,获取协议及版本 HTTP/1.1
         String getProtocol()
   7,获取客户机的IP地址
         String getRemoteAddr()
 */
@WebServlet("/hang")
public class ServletReqHang extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        System.out.println("--------");
        System.out.println(req.getContextPath());
        System.out.println("--------");
        System.out.println(req.getServletPath());
        System.out.println("--------");
        System.out.println(req.getQueryString());
    }

}
