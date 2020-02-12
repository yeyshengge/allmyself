package com.zps.BaoZhuang;

//基本数据类型与字符串类型直接的相互转换
//基本类型转换为字符串方法一：直接用基本数据类型的值+“空格”
public class IntegerDemo02 {
    public static void main(String[] args) {
        int i = 100;
        String i1 = "101";
        String i2 = i + "";
        System.out.println(i2 + 102);

        String i3 = Integer.toString(i);
        System.out.println(i3 + 103);

        String i4 = String.valueOf(i);
        System.out.println(i4 + 104);


        int i5 = Integer.parseInt(i2);
        System.out.println(i5 + 105);
    }
}
