package com.zps.test;


import java.util.Random;

public class HelloWord {
    public static void main(String[] args) {
        Random a = new Random();
        for (; ; ) {
            for (int i = 0; i < 100; i++) {
                int num = a.nextInt(100)+20;
                for (int j = 0; j < num; j++) {
                    int b = a.nextInt(2);
                    System.out.print(b);
                }
                System.out.println();
            }
        }
    }

}





