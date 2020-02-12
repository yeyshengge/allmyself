package Day12.demo;

import Day04.DateUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

public class SendUDP {
    public static void main(String[] args) throws IOException {
        //创建连接对象
        DatagramSocket ds = new DatagramSocket();
        //标准流输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String len;
        while ((len = br.readLine()) != null) {
            if (len.equals("886")) {
                break;
            } else {
                //DatagramPacket​(byte[] buf, int length, InetAddress address, int port)
                // 构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号。
                DateUtils du = new DateUtils();
                Date d = new Date();
                String ss = du.dateToString(d, "yyyy/MM/dd HH:mm:ss");
                String s = ss.toString()+"----->";
                byte[] bys = (s+len).getBytes();
                InetAddress name = InetAddress.getByName("192.168.0.8");
                DatagramPacket dp = new DatagramPacket(bys, bys.length, name, 10089);
                ds.send(dp);
            }
        }
        ds.close();
    }
}
