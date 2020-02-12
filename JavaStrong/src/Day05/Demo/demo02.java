package Day05.Demo;
/*
一: 分析以下需求，并用代码实现
1.键盘录入6个int类型的数据存数数组arr中
2.将arr数组中的内容反转
3.将翻转后的数组角标为奇数的互相交换 1和3换, 3和5换,以此类推
4.最后将数组最后一个角标为奇数的元素 和数组中第一个角标为奇数的元素交换
5.打印最终的数组(实现了1-4步之后的数组)
6.如：用户输入的6个int数字为[1,2,3,4,5,6],最后输出的结果为[6, 5, 4, 1, 2, 3]
 */

import java.util.Scanner;

public class demo02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("原数组");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("数组中的内容反转");
        reserves(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("将翻转后的数组角标为奇数的互相交换 1和3换, 3和5换,以此类推");
        replace(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("最后将数组最后一个角标为奇数的元素 和数组中第一个角标为奇数的元素交换");

        replace1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reserves(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // int[] arr = {1,2,3,6,5,8,9,4};
    //3.将翻转后的数组角标为奇数的互相交换 1和3换, 3和5换,以此类推
    public static void replace(int[] arr) {
        for (int i = 1; i < arr.length - 2; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 2];
            arr[i + 2] = temp;
        }
       /* for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }

    //4.最后将数组最后一个角标为奇数的元素 和数组中第一个角标为奇数的元素交换!!!!!!!我做的是将第一个奇元素与最后一个奇元素互换
    public static void replace1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (arr[i] % 2 == 1 && arr[j] % 2 == 1) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    return;
                }
            }
        }
    }
}
