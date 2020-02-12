package Day12.work.KeyBoard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/*
键盘录入数据传输
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("192.168.29.61", 10003);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("886")) {
                break;
            }
            OutputStream os = s.getOutputStream();
            os.write(line.getBytes());
        }
        s.close();
    }
}
