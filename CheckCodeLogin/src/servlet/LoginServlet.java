package servlet;


import dao.LoginDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
案例需求：
	1. 访问带有验证码的登录页面login.jsp
	2. 用户输入用户名，密码以及验证码。
		* 如果用户名和密码输入有误，跳转登录页面，提示:用户名或密码错误
		* 如果验证码输入有误，跳转登录页面，提示：验证码错误
		* 如果全部输入正确，则跳转到主页success.jsp，显示：用户名,欢迎您
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");

        HttpSession session = request.getSession();
        String ckCode = (String) session.getAttribute("CkCode");
        session.removeAttribute("CkCode");
        if (ckCode != null) {
            if (ckCode.equalsIgnoreCase(checkcode)) {
                //如果验证码相同
                //验证登录注册
                User u = new User(username, password);
                LoginDao loginDao = new LoginDao();
                User user = loginDao.login(u);
                if (user.getUpswd() == null || user.getUname() == null) {
                    //如果失败
                    request.setAttribute("login_error", "用户名或密码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);

                } else {
                    //如果成功
                    HttpSession session1 = request.getSession();
                    session1.setAttribute("username", username);
                    response.sendRedirect(request.getContextPath() + "/success.jsp");

                }
            }


        } else {
            //如果验证码不同
            request.setAttribute("code_error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

