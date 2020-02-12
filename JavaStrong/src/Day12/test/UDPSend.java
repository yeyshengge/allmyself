package Day12.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSend {
    public static void main(String[] args) throws IOException {
        //192.168.29.61
        //创建连接对象
        DatagramSocket ds = new DatagramSocket();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line=br.readLine())!=null){
            if (line.equals("886")){
                break;
            }else {
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("192.168.225.1"),12345);
                ds.send(dp);
            }
        }
        ds.close();
        br.close();
    }
}
