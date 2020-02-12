package Day10.demo;

import java.io.PrintStream;

/*
out
public static final PrintStream out“标准”输出流。 此流已经打开并准备好接受输出数据。
通常，此流对应于显示输出或由主机环境或用户指定的另一个输出目标。
 */
public class SystemOut {
    public static void main(String[] args) {
        PrintStream out = System.out;
        out.print("sdad");
        out.println("aaa");

        System.out.println("sad");
    }
}
