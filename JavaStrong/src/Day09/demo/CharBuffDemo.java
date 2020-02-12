package Day09.demo;

import java.io.*;

/*
BufferedWriter​(Writer out) 创建使用默认大小的输出缓冲区的缓冲字符输出流。
BufferedReader​(Reader in) 创建使用默认大小的输入缓冲区的缓冲字符输入流。
 */
public class CharBuffDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        //写数据。
        bw.write("hello\r\n");
        bw.write("word\r\n");
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        //单个字符数据缓冲
        /*int a;
        while ((a=br.read())!=-1){
            System.out.print((char)a);
        }*/

        char[] ch =new char[1024];
        int b;
        while ((b=br.read(ch))!=-1){
            System.out.println(new String(ch,0,b));
        }

        br.close();
    }
}

