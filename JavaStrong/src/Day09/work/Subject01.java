package Day09.work;

import Day01.Work.A;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//E:\ideaspacework\JavaStrong\src\Day09\java.txt
/*
题目一:
	键盘输入n个int类型数据,将每一个int类型的数据存储到集合
	注意:当用户输入：”886”时，停止输入。
	最后将集合里的数据写入到文件,且保证数据能够看得懂
	例如输入的数据为:44 11 22 33, 那么最后文件中的数据格式为:
	11
	22
	33
	44
 */
public class Subject01 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.println("请输入int类型的数据：");
            int a = sc.nextInt();
            list.add(a);
            if (a == 886) {
                break;
            }
        }
        System.out.println(list);
        Collections.sort(list);
        Collections.reverse(list);

        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "");//一定要加空格，转换为字符串。
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
