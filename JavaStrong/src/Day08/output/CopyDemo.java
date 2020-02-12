package Day08.output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis  = new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day08\\output\\java.txt");

        FileOutputStream fos = new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day08\\output\\copyjava.txt");

        //一次读取一个字节数组
        /*byte[] b = new byte[1024];
        int len;
        while ((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        */

        //一次读取一个字节
        int b;
        while ((b=fis.read())!=-1){
            fos.write(b);
        }

        fis.close();
        fos.close();



    }
}
