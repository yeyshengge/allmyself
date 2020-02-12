package com.zps.BaoZhuang;

public class IntegerDemo {
    public static void main(String[] args) {
        //装箱
        Integer i = new Integer(1);
        System.out.println(i);

        Integer a = new Integer("1");
        System.out.println(a);

        Integer a1 = Integer.valueOf(1);
        System.out.println(a1);

        Integer i2 = Integer.valueOf("111");
        System.out.println(i2);
        //拆箱
        int i1 = i2.intValue();
        System.out.println(i1);
    }

}
