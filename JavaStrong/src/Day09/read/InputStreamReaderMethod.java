package Day09.read;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
int read​() 读一个字符
int read​(char[] cbuf, int offset, int length) 将字符读入数组的一部分。
 */
public class InputStreamReaderMethod {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));

        //int read​() 读一个字符
       /* int a=isr.read();
        System.out.println(a);
        a=isr.read();
        System.out.println(a);
        a=isr.read();
        System.out.println(a);*/

        //一次读一个数据循环
        /*int a;
        while ((a=isr.read())!=-1){
            System.out.println((char)a);
        }*/


        //int read​(char[] cbuf, int offset, int length) 将字符读入数组的一部分。
        char[] ah = new char[1024];
        int a;
        while ((a = isr.read(ah)) != -1) {
            System.out.println(new String(ah, 0, a));
        }


        isr.close();


    }
}
