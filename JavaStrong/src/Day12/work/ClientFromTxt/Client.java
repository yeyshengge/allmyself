package Day12.work.ClientFromTxt;

import java.io.*;
import java.net.Socket;

/*
键盘录入数据传输
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.29.61", 10003);

        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day12\\work\\ClientFromTxt\\java.txt"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.close();
    }
}
