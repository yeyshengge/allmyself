package Day09.demo;

import Day01.Work.B;

import java.io.*;

/*
源java文件E:\ideaspacework\JavaStrong\src\Day09\read\InputStreamReaderMethod.java
复制到E:\test\copy.java
 */
public class BufferedJavaDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\read\\InputStreamReaderMethod.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\test\\copy.java"));

        //一次读写一个字符。
        /*int a;
        while ((a=br.read())!=-1){
            bw.write(a);
        }*/

        //一次读写一个字符数组。
        int b;
        char[] ch = new char[1024];
        while ((b = br.read(ch)) != -1) {
            bw.write(ch, 0, b);
        }
        br.close();
        bw.close();
    }
}
