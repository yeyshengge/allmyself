package day14;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/parameter")
public class ServletReqParameter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        System.out.println("--------");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));
        System.out.println("--------");


        //Enumeration<String> pn = request.getParameterNames();

       /* while (pn.hasMoreElements()) {
            String s = pn.nextElement();
            String parameter = request.getParameter(s);
            System.out.println(s + "----" + parameter);
        }
*/
        System.out.println("--------");
        Map<String, String[]> pm = request.getParameterMap();
        Set<String> s = pm.keySet();
        for (String ss : s) {
            String[] val = pm.get(ss);
            for (String value : val) {
                System.out.println(ss + "-------" + value);
            }
        }

    }
}
