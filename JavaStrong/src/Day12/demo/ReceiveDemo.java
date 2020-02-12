package Day12.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        // DatagramSocket​(int port) 构造数据报套接字并将其绑定到本地主机上的指定端口。
        DatagramSocket ds = new DatagramSocket(10086);

        //DatagramPacket​(byte[] buf, int length) 构造一个 DatagramPacket用于接收长度为 length数据包。
        byte[] bys = new byte[1024];

        DatagramPacket dp = new DatagramPacket(bys,bys.length);

        ds.receive(dp);

        //byte[] getData​() 返回数据缓冲区。
        byte[] data = dp.getData();
        int len=dp.getLength();
        System.out.println(new String(data,0,len));


    }
}
