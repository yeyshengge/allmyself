package com.zps.demo;

import java.util.Scanner;

public class Pingjie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("please int:");
        String s = input.nextLine();
        Pingjie ss=new Pingjie();
        ss.pj(s);

    }

    public  void pj(String s ) {
        System.out.print("[");
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
           if (i<s.length()-1){
               System.out.print(s.charAt(i)+",");
           }else{
               System.out.print(s.charAt(i));
           }

        }
        System.out.println("]");
    }
}
