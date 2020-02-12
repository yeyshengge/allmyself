package com.zps.Thread;

public class MyRunableDemo {
    public static void main(String[] args) {
        MyRunable mr = new MyRunable();
        Thread t1 = new Thread(mr,"高铁");
        Thread t2 = new Thread(mr,"飞机");


        t1.start();
        t2.start();
    }
}
