package Day12.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //ServerSocket​(int port) 创建绑定到指定端口的服务器套接字。
        ServerSocket ss = new ServerSocket(10000);
        Socket ac = ss.accept();
        InputStream is = ac.getInputStream();
        int a;
        byte[] bys = new byte[1024];
        while ((a = is.read(bys)) != -1) {
            System.out.println(new String(bys, 0, a));
        }
        ss.close();
    }
}
