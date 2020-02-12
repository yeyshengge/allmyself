package Day12.work.process;

import java.io.*;
import java.net.Socket;

/*
键盘录入数据传输
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 10003);

        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day12\\work\\process\\java.txt"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.shutdownOutput();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String ss = br2.readLine();
        System.out.println("服务器反馈" + ss);

        br.close();
        s.close();
    }
}
