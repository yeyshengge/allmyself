package servlet;

import entity.User;
import service.UserListInter;
import serviceImpl.UserListImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        String verifycode = request.getParameter("verifycode");


        HttpSession session = request.getSession();
        Object ckCode = session.getAttribute("CkCode");
        session.removeAttribute("CKCode");

        UserListInter ul = new UserListImpl();
        List<User> all = ul.findAll();

        boolean flag = false;
        if (verifycode != null) {
            if (verifycode.equalsIgnoreCase((String) ckCode)) {
                //如果验证码相同
                //判断用户输入是否正确
                if (username != null || password != null) {
                    for (User user : all) {

                        if (user.getName().equals(username) && user.getPassword().equals(password)) {
                            //如果相同
                            flag = true;
                            HttpSession session1 = request.getSession();
                            session1.setAttribute("username", username);

                            response.sendRedirect(request.getContextPath() + "/index.jsp");
                            break;
                        }
                    }
                    if (flag == false) {
                        //如果用户名错误
                        request.setAttribute("login_error", "账号或密码错误");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                }


            } else {
                //如果验证码不同
                request.setAttribute("code_error", "验证码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        this.doPost(request, response);
    }
}
