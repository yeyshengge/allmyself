package com.zps.web;

import com.zps.domain.Movice;
import com.zps.domain.PageBean;
import com.zps.service.IndexService;
import com.zps.service.impl.IndexServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index/*")
public class IndexServlet extends BaseServlet {
    private IndexService is = new IndexServiceImpl();

    /**
     * 页面内容
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String searchName = request.getParameter("searchName");
        String kind = request.getParameter("kind");
        System.out.println("当前页码" + currentPageStr);
        System.out.println("每页的条数" + pageSizeStr);
        System.out.println("搜索内容" + searchName);

        //System.out.println("king" + kind);

        int currentPage = 0;
        if (currentPageStr == null || "".equals(currentPageStr) || currentPageStr.length() < 0) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(currentPageStr);
        }
        int pageSize = 0;
        if (pageSizeStr == null || "".equals(pageSizeStr) || pageSizeStr.length() < 0) {
            pageSize = 8;
        } else {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        PageBean<Movice> list = is.findList(currentPage, pageSize, searchName, kind);

        String json = toJson(list);

        sendJson(json, response);
    }


    public void into(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idstr = request.getParameter("id");

        int id = Integer.parseInt(idstr);

        Movice m = is.into(id);
        String json = toJson(m);
        sendJson(json, response);
    }


}
