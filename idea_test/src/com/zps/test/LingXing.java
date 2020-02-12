package com.zps.test;

import java.util.Scanner;

public class LingXing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入中间层个数(奇数)：");
        int x=input.nextInt();
        if(x%2==1) {
            int s = (x - 1) / 2;
            for (int i = 0; i <= s; i++) {
                for (int j = 0; j < s - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k <= 2 * i; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for (int a = 1; a <= s; a++) {
                for (int b = 0; b < a; b++) {
                    System.out.print(" ");
                }
                for (int c = 2 * (s - a); c >= 0; c--) {
                    System.out.print("*");
                }
                System.out.println();

            }
        }else {
            System.out.println("你的输入有误");
        }
    }
}
