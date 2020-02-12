package Day12.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10002);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();
        byte[] bys =new byte[1024];
        int read = is.read(bys);
        System.out.println(new String(bys,0,read));

        OutputStream os = accept.getOutputStream();
        os.write("已收到".getBytes());

        ss.close();
    }
}
