package Day12.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(55555);
        while (true){
            byte[] bys = new byte[1024];

            DatagramPacket dp = new DatagramPacket(bys,bys.length);

            ds.receive(dp);
            byte[] data = dp.getData();

            System.out.println(new String(data,0,dp.getLength()));

        }


    }
}
