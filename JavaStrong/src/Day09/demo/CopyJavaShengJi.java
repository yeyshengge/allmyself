package Day09.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
源java文件E:\ideaspacework\JavaStrong\src\Day09\read\InputStreamReaderMethod.java
复制到E:\test\copy.java
FileReader​(String fileName) 创建一个新的 FileReader ，给定要读取的文件的名称。
FileWriter​(String fileName) 构造一个给定文件名的FileWriter对象。
 */
public class CopyJavaShengJi {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\read\\InputStreamReaderMethod.java");
        FileWriter fw = new FileWriter("E:\\test\\copy.java");
        //一次读写一个字符
       /* int a;
        while ((a=fr.read())!=-1){
            fw.write(a);
        }*/
       //一次读写一个数组字符
        char ch[] = new char[1024];
        int b;
        while ((b=fr.read(ch))!=-1){
            fw.write(ch,0,b);
        }
        fr.close();
        fw.close();
    }
}
