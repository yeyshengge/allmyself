package com.zps.demo;

public class Stringdemo {
    public static void main(String[] args) {
        String s = new String();
        System.out.println(s);
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println(s2);
        byte[] a = {97,98,99};
        String s3 = new String(a);
        System.out.println(s3);
        System.out.println(s3.equals(s2));
    }

}
