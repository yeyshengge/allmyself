package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.IndexServiceInter;
import cn.itcast.travel.service.impl.IndexServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index/*")
public class IndexServlet extends BaseServlet {
    private IndexServiceInter is = new IndexServiceImpl();

    public void queryTheme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //定义一个字符串用来模糊查询
        String str = "西安";

        List<Route> list = is.queryThemeByName(str);
        String json = toJson(list);
        sendJson(json, response);
    }

    public void queryNew(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Route> list = is.queryNew();
        String json = toJson(list);
        sendJson(json, response);
    }
}
