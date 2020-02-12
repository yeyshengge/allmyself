package servlet;

import entity.PageBean;
import entity.User;
import service.UserListInter;
import serviceImpl.UserListImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String search_name = request.getParameter("search_name");
        String search_address = request.getParameter("search_address");
        request.setAttribute("search_name", search_name);
        request.setAttribute("search_address", search_address);
        //获取总条数
        UserListInter u = new UserListImpl();
        int totalCount = u.datacount(search_name, search_address);
       // System.out.println("lalallalaalalal" + totalCount);
        //获取当前页码数
        String currentPage = request.getParameter("pg");

        //获取每页展示的行数
        String rows = request.getParameter("rows");
        //获取总页码
        if (currentPage != null && "".equals(currentPage)) {
            currentPage = "1";
        }
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (Integer.parseInt(currentPage) <= 0) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        int totalpage = 0;
        if (totalCount % Integer.parseInt(rows) == 0) {
            totalpage = totalCount / Integer.parseInt(rows);
        }
        if (totalCount % Integer.parseInt(rows) != 0) {
            totalpage = totalCount / Integer.parseInt(rows) + 1;
        }
        if (Integer.parseInt(currentPage) > totalpage) {
            currentPage = totalpage + "";
        }


        //获取开始查询的索引
        int start = (Integer.parseInt(currentPage) - 1) * Integer.parseInt(rows);

        //调用方法,通过限制条数跟开始索引获取返回的list集合
        UserListInter userList = new UserListImpl();
        List<User> user = userList.limitcount(start, Integer.parseInt(rows), search_name, search_address);
       // System.out.println("-->" + user);
        PageBean page = new PageBean(totalCount, totalpage, user, Integer.parseInt(currentPage), Integer.parseInt(rows));
        request.setAttribute("page", page);
        request.setAttribute("list", user);
        request.getRequestDispatcher("/list.jsp").forward(request, response);


        //System.out.println("条数：" + totalCount + "当前页码：" + currentPage + "每页行数：" + rows + "总页码" + totalpage + "开始查询的索引" + start);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
