package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.RouteServiceInter;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteServiceInter r = new RouteServiceImpl();
    private FavoriteServiceImpl f = new FavoriteServiceImpl();

    /**
     * 查询页面内容
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPagestr = request.getParameter("currentPage");
        String pageSizestr = request.getParameter("pageSize");
        String cidstr = request.getParameter("cid");

        String rname = request.getParameter("rname");
        //rname = new String(rname.getBytes("iso-8859-1"), "utf-8");


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
            pageSize = 5;
        }

        int cid = 0;
        if (cidstr != null && cidstr.length() > 0 && !"null".equals(cidstr)) {
            cid = Integer.parseInt(cidstr);
        }

        PageBean<Route> pb = r.pageQuery(cid, currentPage, pageSize, rname);


        String json = toJson(pb);
        //System.out.println(json);

        sendJson(json, response);

    }


    /**
     * 根据rid查询详情
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");

        Route route = r.findOne(Integer.parseInt(rid));

        String json = toJson(route);

        //System.out.println(json);
        sendJson(json, response);
    }


    public void findByRidAndUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String rid = request.getParameter("rid");
        int uid;
        if (user == null) {
            uid = 0;
        } else {
            uid = user.getUid();
        }
        if (rid == null || "null".equals(rid)) {
            rid = "0";
        }

        System.out.println("rid:" + rid + "uid" + uid);
        boolean flag = f.findByRidAndUid(Integer.parseInt(rid), uid);


        String json = toJson(flag);
        System.out.println("json" + json);
        sendJson(json, response);

    }


    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        String uid = request.getParameter("uid");

        if (uid == null) {
            return;
        }

        f.addFavrite(rid,uid);


    }


}


