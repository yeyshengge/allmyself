package Day09.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
点名器
E:\ideaspacework\JavaStrong\src\Day09\java.txt
 */
public class DianMingQi {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        br.close();
        // System.out.println(list);
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        while (true) {
            System.out.println("1,点名");
            System.out.println("2,退出");
            System.out.println("请输入操作数字：");
            int s = sc.nextInt();
            if (s == 1) {
                int a = r.nextInt(list.size());

                System.out.println("恭喜你，中奖了" + list.get(a));

            } else if (s == 2) {
                break;
            } else {
                System.out.println("你的输入无效");
                break;
            }
        }
    }
}
