package servlet;

import service.UserListInter;
import serviceImpl.UserListImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/XuanZhongServlet")
public class XuanZhongServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] id = request.getParameterValues("checkbox");
        if ( id != null) {
            for (String s : id) {
                try {
                    int i = Integer.parseInt(s);
                    UserListInter u = new UserListImpl();
                    u.delete(i + "");
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/PageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);


    }
}
