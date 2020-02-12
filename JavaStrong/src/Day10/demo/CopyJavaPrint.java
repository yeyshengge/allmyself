package Day10.demo;

import java.io.*;

/*
E:\test\llll.java为源文件
E:\test\test.java为目标文件
 */
public class CopyJavaPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\test\\llll.java"));
        PrintWriter pw = new PrintWriter(new FileWriter("E:\\test\\test.java"), true);
        String a;
        while ((a = br.readLine()) != null) {
            pw.println(a);
        }
        br.close();
        pw.close();

    }
}
