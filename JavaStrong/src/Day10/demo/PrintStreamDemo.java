package Day10.demo;

import java.io.IOException;
import java.io.PrintStream;

/*
PrintStream​(String fileName) 使用指定的文件名创建新的打印流，无需自动换行。
E:\ideaspacework\JavaStrong\src\Day10
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {

        PrintStream ps = new PrintStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt");
        //调用父类OutputStream中的方法
        ps.write(97);//显示a,会转码,

        //调用自己特有的方法
        ps.println(97);//显示97,不会转码。



    }
}
