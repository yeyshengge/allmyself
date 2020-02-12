package Day11.work;

import java.util.Scanner;

//1,输入三个整数x,y,z，请把这三个数由小到大输出。
public class Subject01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第1个整数");
        int a = sc.nextInt();
        System.out.println("请输入第2个整数");
        int b = sc.nextInt();
        System.out.println("请输入第3个整数");
        int c = sc.nextInt();
        int index = a>b?a:b;
        System.out.println(index>c?index:c);
    }
}
