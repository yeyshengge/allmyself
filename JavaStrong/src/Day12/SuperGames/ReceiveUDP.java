package Day12.SuperGames;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10089);
        byte[] bys2 = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(bys2, bys2.length);
        ds.receive(dp2);
        byte[] data2 = dp2.getData();
        int length2 = dp2.getLength();
        System.out.println(new String(data2, 0, length2));

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day12\\SuperGames\\poker.txt"));
        bw.write(new String(data2, 0, length2));
        bw.flush();


        while (true) {
            //DatagramPacket​(byte[] buf, int length) 构造一个 DatagramPacket用于接收长度为 length数据包。
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            ds.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();
            System.out.println("地主：" + new String(data, 0, length));
        }
    }
}
