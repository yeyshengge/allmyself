package Day09.write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

//写入数据的方法
/*
void write​(int c) 写一个字符
void write(char[] c)写入一个字符数组
void write​(char[] cbuf, int off, int len) 写入字符数组的一部分。
void write(String str) 写入一个字符串
void write​(String str, int off, int len) 写一个字符串的一部分。
 */
public class OutputStreamWriteMethod {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt", true));

        //void write​(int c) 写一个字符;
        //osw.write(97);
        osw.flush();
        //void write(char[] c)写入一个字符数组
        char[] ch = {'a', 'b', 'c', 'd', 'e'};
        //osw.write(ch);
        //void write​(char[] cbuf, int off, int len) 写入字符数组的一部分。
        //osw.write(ch,0,2);

        //void write(String str) 写入一个字符串
        //osw.write("HelloWorld\r\n");
        osw.write("HelloWorld", 0, 5);

        osw.close();

    }
}
