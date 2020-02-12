package Day12.work.process;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket s;


    public ServerThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        int cout = 0;
        try {

            File f = new File("E:\\ideaspacework\\JavaStrong\\src\\Day12\\work\\process\\java" + cout + ".txt");
            while(f.exists()) {
                cout++;
                f = new File("E:\\ideaspacework\\JavaStrong\\src\\Day12\\work\\process\\java" + cout + ".txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw2.write("服务器接收成功");
            bw2.newLine();
            bw2.flush();
            //System.out.println(s);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
