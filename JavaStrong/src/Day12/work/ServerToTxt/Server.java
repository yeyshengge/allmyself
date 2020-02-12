package Day12.work.ServerToTxt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
//服务器接收写入文本
// E:\ideaspacework\JavaStrong\src\Day12\work\ClientFromTxt\java.txt
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day12\\work\\ServerToTxt\\java.txt"));
        Socket ac = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(ac.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        ss.close();
    }
}
