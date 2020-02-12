package Day09.demo;

import java.io.*;

/*
源java文件E:\ideaspacework\JavaStrong\src\Day09\read\InputStreamReaderMethod.java
复制到E:\test\copy.java
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day09\\read\\InputStreamReaderMethod.java"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\test\\copy.java"));

        //一次读写一个字符数据
        /*int b;
        while ((b = isr.read()) != -1) {
            osw.write(b);
        }*/


        //一次读写一个字符数组
        char[] ch = new char[1024];
        int a;
        while ((a = isr.read(ch)) != -1) {
            osw.write(ch, 0, a);
        }

        isr.close();
        osw.close();
    }
}
