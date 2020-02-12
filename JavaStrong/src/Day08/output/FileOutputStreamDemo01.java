package Day08.output;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamDemo01 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day08\\output\\java.txt");
        for (int i = 0; i < 1024; i++) {
            fos.write(97);
        }

        int a=0;
        FileInputStream fis = new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day08\\output\\java.txt");
        byte[] b = new byte[1024];
        int len;
        while ((len = fis.read(b)) != -1) {

            System.out.println(new String(b, 0, len).length());

        }
        fos.close();
        fis.close();
    }
}
