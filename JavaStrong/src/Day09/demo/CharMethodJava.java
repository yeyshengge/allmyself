package Day09.demo;

import java.io.*;

/*
使用字符缓冲流特有的功能实现java文件的复制
源java文件E:\ideaspacework\JavaStrong\src\Day09\read\InputStreamReaderMethod.java
复制到E:\test\copy.java
 */
public class CharMethodJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\read\\InputStreamReaderMethod.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("E:\\test\\copy.java")));

        String str;
        while ((str = br.readLine()) != null) {
            bw.write(str);//写一行字符
            bw.newLine();//换行
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
