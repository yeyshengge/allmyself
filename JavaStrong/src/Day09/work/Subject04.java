package Day09.work;

import java.io.*;
import java.util.Scanner;

/*
题目四：实现一个验证码小程序，要求如下：
	1. 在项目根目录下新建一个文件：data.txt,键盘录入3个字符串验证码，并存入data.txt中，要求一个验证码占一行；
	2. 键盘录入一个需要被校验的验证码
		如果输入的验证码在data.txt中存在：	在控制台提示验证成功
		如果输入的验证码在data.txt中不存在：在控制台提示验证失败
		E:\ideaspacework\JavaStrong\src\Day09\java.txt
 */
public class Subject04 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt", true));
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请录入第" + (i + 1) + "个验证码");
            String s = sc.nextLine();
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        System.out.println("请输入你的验证码：");
        String s2 = sc.nextLine();
        int a = 0;
        String s3;
        while ((s3 = br.readLine()) != null) {
            if (s3.equals(s2)) {
                a++;
            }
        }
        if (a > 0) {
            System.out.println("验证通过");
        } else {
            System.out.println("验证失败");
        }
        br.close();


    }
}
