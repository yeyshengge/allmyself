package Day12.test;

import java.io.*;
import java.net.Socket;

public class TCPClinet {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.29.85",12313);

        OutputStream os = s.getOutputStream();
        os.write("cao尼玛".getBytes());

        InputStream is = s.getInputStream();
        byte[] bys =new byte[1024];
        int a=is.read(bys);
        System.out.println(new String(bys,0,a));

        s.close();
    }
}
