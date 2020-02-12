package day23.anli.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import day23.anli.service.LoadService;
import day23.anli.service.impl.LoadServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进来了");
        LoadService ls = new LoadServiceImpl();
      //  List lsit = ls.load();
        String json = ls.jsonload();
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        //mapper.writeValue(response.getWriter(), json);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
