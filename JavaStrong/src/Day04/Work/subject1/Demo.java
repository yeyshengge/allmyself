package Day04.Work.subject1;
/*一:键盘录入一个年份,判断该年是否为闰年
	用两种方式完成:
	第一种可以根据二月共有多少天来判断
	第二种可以根据一年总共有多少天来判断*/


import java.util.Calendar;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please int year:");
        int a = input.nextInt();

       /* //第一种方法
        Calendar cal = Calendar.getInstance();
        cal.set(a, 2, 1);
        cal.add(Calendar.DATE, -1);
        int i = cal.get(Calendar.DATE);
        //System.out.println(i);
        if (i == 28) {
            System.out.println(a + "年的二月有" + i + "天，是平年");
        } else {
            System.out.println(a + "年的二月有" + i + "天，是润年");
        }*/


        //第二种方法
        Calendar cal = Calendar.getInstance();
        cal.set(a, 11, 31);
        int i = cal.get(Calendar.DAY_OF_YEAR);
        //System.out.println(i);
        if (i == 366) {
            System.out.println(a + "年是闰年");
        } else {
            System.out.println(a + "是平年");
        }


    }
}
