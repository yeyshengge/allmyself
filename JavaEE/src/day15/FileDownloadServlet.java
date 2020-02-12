package day15;

import Utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/*
文件下载需求：
	1. 页面显示超链接
	2. 点击超链接后弹出下载提示框
	3. 完成图片文件下载
 */
@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");
        System.out.println(filename);
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        System.out.println(realPath);
        FileInputStream fis = new FileInputStream(realPath);


        String ag = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(ag, filename);


        String mimeType = context.getMimeType(filename);




        response.setHeader("content-type", mimeType);
        response.setHeader("content-disposition", "attachment;filename=" + filename);
        ServletOutputStream sos = response.getOutputStream();
        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
            sos.write(bys, 0, len);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
