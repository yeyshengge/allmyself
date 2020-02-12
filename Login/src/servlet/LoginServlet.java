package servlet;


import dao.LoginDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);

        User u = new User(username, password);
        System.out.println("测试1");
        LoginDao loginDao = new LoginDao();
        System.out.println("测试2");
        User user = loginDao.login(u);
        System.out.println("----" + user);
        if (user.getUpswd() == null || user.getUname() == null) {
            request.getRequestDispatcher("/FailServlet").forward(request, response);
        } else {
            request.setAttribute("name", user.getUname());
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

