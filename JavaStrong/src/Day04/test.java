package Day04;

import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
       /* 1.键盘录入班级人数
        2.根据录入的班级人数创建数组
        3.利用随机数产生0-100的成绩(包含100不包含0),且将成绩赋值给数组
        4.要求:
        (1)打印该班级的不及格人数
                (2)打印该班级的平均分
                (3)打印该班级的总分
                (3)演示格式如下:
        请输入班级人数:
        键盘录入:100
        控制台输出:
        不及格人数:19
        班级平均分:87
        班级总分:xxx*/

        Scanner input = new Scanner(System.in);
        System.out.println("please int number:");
        int a = input.nextInt();
        int arr[] = new int[a];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int b = r.nextInt(100) + 1;
            arr[i] = b;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //平均数
        int avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        System.out.println("总分为" + avg);
        System.out.println("平均数为：" + (avg / a));
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<60){
                temp++;
            }

        }
        System.out.println("不及格人数："+temp);
    }
}
