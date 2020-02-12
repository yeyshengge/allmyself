package Day12.work.KeyBoard;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);

        Socket ac = ss.accept();
        InputStream is = ac.getInputStream();
        byte[] bys = new byte[1024];
        int a;
        while ((a = is.read(bys)) != -1) {
            System.out.println(new String(bys, 0, a));
        }
    }
}
