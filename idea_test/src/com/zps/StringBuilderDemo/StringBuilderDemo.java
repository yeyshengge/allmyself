package com.zps.StringBuilderDemo;

public class StringBuilderDemo {
    public static void main(String[] args) {

        /*tringBuilder bu = new StringBuilder();
        StringBuilder bu2 = bu.append("abc");
        bu.append("asffbc").append(111).append('接');
        System.out.println(bu);
        System.out.println(bu2);
        System.out.println(bu==bu2);*/

//stringbuilder跟string转换


        String  str = "hello";
        System.out.println(str);
        StringBuilder a = new StringBuilder(str);
        a.append("word");
        System.out.println(a);
        String s = a.toString();
        System.out.println(s);



    }
}
