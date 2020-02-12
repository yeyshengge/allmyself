package com.zps.test;

public class Phone {
    String name;
    int price;
    static {
        System.out.println("静态块");
    }


    public Phone(){
        System.out.println("无参构造");
    }


    public void call(){
        System.out.println("打电话");
    }

    public void sedMessage(){
        System.out.println("发信息");
    }

}
