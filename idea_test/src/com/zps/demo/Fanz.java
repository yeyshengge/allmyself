package com.zps.demo;

import java.util.Scanner;

public class Fanz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please int:");
        String s = input.nextLine();

       String c = fz(s);
        System.out.println(c);
    }


    public static String fz(String s) {
        StringBuilder ss = new StringBuilder(s);

        ss.reverse();


        return ss.toString();
    }
}






