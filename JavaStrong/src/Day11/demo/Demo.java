package Day11.demo;

import Day01.Work.D;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
1.控制台提示用户输入自己的出生日期，计算该用户已经出生了多少天，并输出到控制台；
2.如果用户输入的生日日期格式有误，需要提示用户，格式有误，并让其继续输入；
提示：可以使用SimpleDateFormat类和Date类去实现
 */
public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long now = System.currentTimeMillis();
        while (true) {
            System.out.println("请输入你的出生日期（yyyy-MM-dd）:");
            String birth = sc.next();
            try {
                Date d = sdf.parse(birth);
                if (Integer.parseInt(birth.split("-")[0]) < 1970) {
                    System.out.println("你输入的生日日期格式有误,请重新输入：");
                    continue;
                }
                if (Integer.parseInt(birth.split("-")[1]) < 0 || Integer.parseInt(birth.split("-")[1]) > 12) {
                    System.out.println("你输入的生日日期格式有误,请重新输入：");
                    continue;
                }
                if (Integer.parseInt(birth.split("-")[2]) < 0 || Integer.parseInt(birth.split("-")[2]) > 31) {
                    System.out.println("你输入的生日日期格式有误,请重新输入：");
                    continue;
                }
                //如果输入正确
                long day = (now - d.getTime());
                System.out.println("您已出生了" + day / (1000 * 60 * 60 * 24) + "天");
                break;
            } catch (ParseException e) {
                System.out.println("你输入的生日日期格式有误,请重新输入：");
            }
        }
    }
}
