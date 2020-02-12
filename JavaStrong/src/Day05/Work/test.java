package Day05.Work;

import java.util.Random;
import java.util.Scanner;

/*
1、定义两个长度为3的数组arr1和arr2，第一个数组使用键盘录入三个值，要求arr1全部是奇数，
如果录入偶数要提示错误重新输入。
第二个数组录入三个7-25的随机数，最后打印出两个数组的总和。
 */
public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个数：");
            int number = input.nextInt();

                if (number % 2 == 0) {
                    System.out.println("请重新输入");
                    i--;
                } else {
                    arr1[i] = number;

                }

        }
        if (arr1[2] == 0) {
            System.exit(0);
        }
        Random r = new Random();
        int sum = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = r.nextInt(19) + 7;
            System.out.println(arr2[i]);
            sum += (arr1[i] + arr2[i]);
        }
        System.out.println("和为" + sum);

    }
}

