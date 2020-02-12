package Day12.demo;

import java.io.*;

public class deno {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\ssss.txt"));
        String line = null;
        for (int i = 0; i < 5; i++) {
            line = br.readLine();
        }

        bw.write(line);
        bw.flush();
        br.close();
        bw.close();


    }
}
