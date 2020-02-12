package Day12.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //Socket​(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定端口号。
        //Socket​(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号。
        //Socket s = new Socket(InetAddress.getByName("190.168.29.61"),10000);
        Socket s = new Socket("192.168.29.61", 10000);
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp".getBytes());
        s.close();


    }
}
