package Day12.work.fankui;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// E:\ideaspacework\JavaStrong\src\Day12\work\ClientFromTxt\java.txt
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day12\\work\\fankui\\java.txt"));
        Socket ac = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(ac.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(ac.getOutputStream()));
        bw2.write("服务器接收成功");
        bw2.newLine();
        bw2.flush();
        //System.out.println(s);
        ss.close();
    }
}
