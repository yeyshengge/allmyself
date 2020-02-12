package Day12.work.ClientFromTxt;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// E:\ideaspacework\JavaStrong\src\Day12\work\ClientFromTxt\java.txt
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day12\\work\\ClientFromTxt\\java.txt",true));
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
