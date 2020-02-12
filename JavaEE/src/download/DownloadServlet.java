package download;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        try {
            FileItemFactory factory = new DiskFileItemFactory();  //工厂实例
            ServletFileUpload upload = new ServletFileUpload(factory);  //ServletFileUpload实例依赖于FileItemFactory工厂
            List<FileItem> itemList = upload.parseRequest(request);  //解析表单字段，封装成一个FileItem实例的集合
            for (FileItem fileItem : itemList) {
                if (!fileItem.isFormField()) {
                    //文件表单字段
                    String fileUpName = fileItem.getName();  //用户上传的文件名
                    File file = new File("d:\\" + fileUpName);  //要保存到的文件
                    if (!file.exists()) {
                        file.createNewFile();  //一开始肯定是没有的，所以先创建出来
                    }
                    System.out.println("开始写了");
                    fileItem.write(file);  //写入，保存到目标文件
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
