package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int hight = 50;

        //获取图片对象
        BufferedImage image = new BufferedImage(width, hight, BufferedImage.TYPE_3BYTE_BGR);
        //获取画笔
        Graphics g = image.getGraphics();
        //填充颜色
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, hight);

        g.setColor(Color.BLACK);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int i1 = r.nextInt(str.length());
            char ch = str.charAt(i1);
            g.drawString(ch + "", r.nextInt(20) + 20 * i, r.nextInt(30) + 10);
            sb.append(ch);
        }
        HttpSession session = request.getSession();
        session.setAttribute("CkCode",sb.toString());


        //画线
        g.setColor(Color.YELLOW);

        for (int i = 0; i < 5; i++) {
            int x1=r.nextInt(width);
            int x2=r.nextInt(width);
            int y1=r.nextInt(hight);
            int y2=r.nextInt(hight);
            g.drawLine(x1,y1,x2,y2);
        }


        //将图片写到网页上
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
