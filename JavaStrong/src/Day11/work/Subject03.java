package Day11.work;

import java.util.Scanner;

//3,题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
public class Subject03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个五位数");
        int i = sc.nextInt();
        String str = i + "";
        StringBuilder sb = new StringBuilder(str);
        if (sb.reverse().toString().equals(str)) {
            System.out.println("是回文数");
        } else {
            System.out.println("不是回文数");
        }


    }
}
