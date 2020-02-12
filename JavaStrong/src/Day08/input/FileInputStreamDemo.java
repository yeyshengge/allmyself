package Day08.input;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\test\\java.txt");
        //int r = fis.read();
        /*System.out.println((char) r);
        r = fis.read();
        System.out.println((char) r);
        r = fis.read();
        System.out.println((char) r);
        r = fis.read();
        System.out.println((char) r);*/
        //当没有数据时会返回-1；

        //然后我们想到了循环
        /*while (r!=-1){
            System.out.print((char)r);
            r=fis.read();
        }*/
        //优化循环，最终方法：
        int a;
        while ((a = fis.read()) != -1) {
            System.out.print((char) a);
        }
        fis.close();
    }
}
