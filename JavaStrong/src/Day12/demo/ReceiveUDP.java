package Day12.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10089);

        while (true) {
            //DatagramPacket​(byte[] buf, int length) 构造一个 DatagramPacket用于接收长度为 length数据包。
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            ds.receive(dp);

            byte[] data = dp.getData();
            int length = dp.getLength();
            System.out.println("对话："+new String(data, 0, length));
        }

    }
}
