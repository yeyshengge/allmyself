package com.zps.Thread;

public class MyThreadDemo {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        MyThread mt2 = new MyThread();

        //mt.run();
        //mt2.run();//单线程
        mt.start();
        mt2.start();

    }
}
