package Day12.relearn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.33.29",12312);
        OutputStream os = s.getOutputStream();
        byte[] bys = "草拟吗".getBytes();
        os.write(bys,0,bys.length);


        InputStream is = s.getInputStream();
        byte[] bys2 = new byte[1024];
        int len;
        int a=is.read(bys2);
        System.out.println(new String(bys2,0,a));

        s.close();



    }
}
