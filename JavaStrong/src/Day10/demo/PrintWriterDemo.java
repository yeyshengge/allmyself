package Day10.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
字符打印流
PrintWriter​(Writer out, boolean autoFlush) 创建一个新的PrintWriter。
PrintWriter​(String fileName) 使用指定的文件名创建一个新的PrintWriter，而不需要自动执行行刷新。
E:\ideaspacework\JavaStrong\src\Day10
 */
public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
   /*     //PrintWriter​(String fileName) 使用指定的文件名创建一个新的PrintWriter，
        PrintWriter pw = new PrintWriter("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt");
        pw.write("adddadad");
        pw.print(Dsda);
        pw.flush();//要一直刷新，太复杂了，看下一个构造方法*/

        //PrintWriter​(Writer out, boolean autoFlush) 创建一个新的PrintWriter。支持print跟println
        PrintWriter pw2 = new PrintWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"),true);
        pw2.println("dsad");
    }
}
