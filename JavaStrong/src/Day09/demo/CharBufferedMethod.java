package Day09.demo;

import Day01.Work.B;

import java.io.*;

/*
操作文件目录--->E:\ideaspacework\JavaStrong\src\Day09\java.txt
String readLine​() 读一行文字。
void newLine​() 写一行行分隔符。
 */
public class CharBufferedMethod {
    public static void main(String[] args) throws IOException {
        //BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt", false));

       /* bw.write("Hello");
        bw.write("World");
        bw.flush();
        bw.close();*/

        /*for (int i = 0; i < 12; i++) {
            bw.write("Hello"+i);
           // bw.write("\r\n");
            bw.newLine();
            bw.flush();
        }*/
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        //读单个字符
        /*int r = br.read();
        System.out.println((char)r);
        */
        /*
        ABCD dad EFG null,当文件中没有数据时，会返回null
         */
        /*String s = br.readLine();
        System.out.println(s);
        s = br.readLine();
        System.out.println(s);
        s = br.readLine();
        System.out.println(s);s = br.readLine();
        System.out.println(s);*/

        String a;
        while ((a = br.readLine()) != null) {
            System.out.println(a);
        }
        br.close();
    }
}
