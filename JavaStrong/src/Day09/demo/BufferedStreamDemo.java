package Day09.demo;

import java.io.*;

public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {

        /*FileOutputStream fos = new FileOutputStream("E:\\test\\java.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);*/
        //简化
        /*
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\java.txt"));
        bos.write("hello".getBytes());
        bos.write("\r\n".getBytes());
        bos.write("java".getBytes());
        byte[] by = "asdafadadafafa".getBytes();
        bos.write(by,0,5);
        bos.close();
        */
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\test\\java.txt"));

        byte[] by = new byte[1024];
        int len;
        while ((len = bis.read(by)) != -1) {
            System.out.println(new String(by, 0, len));
        }
        bis.close();

    }
}
