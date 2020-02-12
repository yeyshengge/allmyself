package Day09.demo;

import Day01.Work.B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
E:\ideaspacework\JavaStrong\src\Day09\java.txt
把文本中的每一行写入集合
 */
public class TxtToArray {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        String a;
        while ((a = br.readLine()) != null) {
            System.out.println(a);
            list.add(a);
        }
        br.close();
        System.out.println(list);
    }
}

