package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.ServiceInter;
import cn.itcast.travel.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String code = request.getParameter("code");
        ServiceInter s = new ServiceImpl();
        //验证代码是否正确
        boolean flag = s.active(code);
        String msg = null;
        if (flag) {
            //正确则给个提示
            msg = "激活成功，请<a href ='login.html'>登录</a>";
        } else {
            //不正确则给个提示
            msg = "噢噢，激活失败，请重试!";
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(msg);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
