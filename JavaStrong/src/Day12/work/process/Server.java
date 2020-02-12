package Day12.work.process;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// E:\ideaspacework\JavaStrong\src\Day12\work\ClientFromTxt\java.txt
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        while (true) {
            Socket s = ss.accept();

            new Thread(new ServerThread(s)).start();
        }
    }
}
