package Day10.AnLi;

import java.util.Random;
import java.util.Scanner;

public class CaiShuZi {
    public static void main(String[] args) {
        caicaicai();
    }

    public static void caicaicai() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int num = r.nextInt(11) + 50;
        System.out.println("系统产生了一个50-60之间的随机数，请猜出这个数字：");
        while (true) {
            int a = sc.nextInt();
            if (a == num) {
                System.out.println("恭喜你，猜中了");
                break;
            }
            if (a > num) {
                System.out.println("比产生的随机数大，请继续猜");
            }
            if (a < num) {
                System.out.println("比产生的随机数小，请继续猜");
            }
        }
    }
}
