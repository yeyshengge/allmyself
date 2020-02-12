package Day09.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
E:\ideaspacework\JavaStrong\src\Day09\java.txt
把ArrayList集合中的文件写入文本，要求每个字符串作为文件中的一行。
 */
public class ArrayToTxt {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("java");
        list.add("C++");
        list.add("C语言");
        System.out.println(list);
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
