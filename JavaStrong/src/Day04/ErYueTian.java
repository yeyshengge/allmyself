package Day04;

//求出指定月份的二月有多少天

import java.util.Calendar;
import java.util.Scanner;

public class ErYueTian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        Calendar cal = Calendar.getInstance();//定义一个Calender的对象

        cal.set(a, 2, 1);//设置为三月，月份从零开始，3月1往前推一天，就是二月的最后一天，然后输入天数

        cal.add(Calendar.DATE, -1);

        System.out.println(cal.get(Calendar.DATE));

    }

}
