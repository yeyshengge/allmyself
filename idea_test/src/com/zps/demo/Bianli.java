package com.zps.demo;

import java.util.Scanner;

//字符串的遍历
public class Bianli {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }


    }

}
