package com.zps.test;

import java.util.Scanner;

public class LingXingStrong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please int num:");
        int dd = input.nextInt();
        int k = dd - 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int z = 0; z < 2 * i - 1; z++) {
                System.out.print(" ");
            }
            if (i > 0) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int temp = 0; temp < 2 * k + 1; temp++) {
            if (temp == 0 || temp == 2 * k) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int a = 0; a < k; a++) {
            for (int b = 0; b <= a; b++) {
                System.out.print(" ");
            }
            System.out.print("*");

            for (int c = 0; c < 2 * (k - a) - 3; c++) {
                System.out.print(" ");
            }
            if (a < k - 1) {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}
