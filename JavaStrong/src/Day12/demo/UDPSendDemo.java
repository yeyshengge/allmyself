package Day12.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
创建连接(DatagramSocket)-->构建数据包(DatagramPacket)-->发送数据包(send)-->关闭连接(close)
 */
public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        // DatagramSocket​() 构造数据报套接字并将其绑定到本地主机上的任何可用端口。
        DatagramSocket ds = new DatagramSocket();

        //DatagramPacket​(byte[] buf, int length, InetAddress address, int port)
        // 构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号。
        byte[] bys = "我草你妈".getBytes();
        InetAddress name = InetAddress.getByName("192.168.29.61");//此处为目标ip地址。
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(bys, bys.length, name, port);

        //void send​(DatagramPacket p) 从此套接字发送数据报包。
        ds.send(dp);

        //void close​() 关闭此数据报套接字。
        ds.close();

    }
}
