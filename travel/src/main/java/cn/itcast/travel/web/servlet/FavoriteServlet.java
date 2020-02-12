package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteServiceInter;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/favorite/*")
public class FavoriteServlet extends BaseServlet {
    private FavoriteServiceInter fs = new FavoriteServiceImpl();

    public void findFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String currentPagestr = request.getParameter("currentPage");
        String pageSizestr = request.getParameter("pageSize");
        //根据uid查询该用户的收藏路线rid
        System.out.println(user.getUid());

        int currentPage = 0;
        if (currentPagestr != null && currentPagestr.length() > 0) {
            currentPage = Integer.parseInt(currentPagestr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;
        if (pageSizestr != null && pageSizestr.length() > 0) {
            pageSize = Integer.parseInt(pageSizestr);
        } else {
            pageSize = 8;
        }

        PageBean<Favorite> pf = fs.queryFavoriteByUid(user.getUid(), currentPage, pageSize);
       /* List<Favorite> list = fs.queryFavoriteByUid(user.getUid(),currentPage);
        System.out.println(list);
        String json = toJson(list);
        sendJson(json, response);*/

        System.out.println(pf);
        String json = toJson(pf);
        sendJson(json, response);
    }

    public void favoriteRank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String routeName = request.getParameter("routeName");
        String moneyUpstr = request.getParameter("moneyUp");
        String moneyDownstr = request.getParameter("moneyDown");
        String currentPagestr = request.getParameter("currentPage");
        String pageSizestr = request.getParameter("pageSize");

        //System.out.println("查询前低"+moneyDownstr+"高"+moneyUpstr);
        int currentPage = 0;
        if (currentPagestr != null && currentPagestr.length() > 0) {
            currentPage = Integer.parseInt(currentPagestr);
        } else {
            currentPage = 1;
        }

        int pageSize = 0;
        if (pageSizestr != null && pageSizestr.length() > 0) {
            pageSize = Integer.parseInt(pageSizestr);
        } else {
            pageSize = 8;
        }

        int moneyUp = 0;
        if (moneyUpstr == null || moneyUpstr.length() < 0 || "".equals(moneyUpstr)) {
            moneyUp = 999999999;
        } else {
            try {
                moneyUp = Integer.parseInt(moneyUpstr);
            } catch (NumberFormatException e) {
                moneyUp = 999999999;
            }
        }


        int moneyDown = 0;
        if (moneyDownstr == null || moneyDownstr.length() < 0 || "".equals(moneyDownstr)) {
            moneyDown = 0;
        } else {
            try {
                moneyDown = Integer.parseInt(moneyDownstr);
            } catch (NumberFormatException e) {
                moneyDown = 0;
            }
        }

        //System.out.println("处理后低"+moneyDown+"高"+moneyUp);
        PageBean<Route> pb = fs.findByNUD(routeName, moneyDown, moneyUp, currentPage, pageSize);

        String json = toJson(pb);
        sendJson(json, response);
    }

}
