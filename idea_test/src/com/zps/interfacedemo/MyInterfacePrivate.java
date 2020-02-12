package com.zps.interfacedemo;

public interface MyInterfacePrivate {


    public default void method1() {
        System.out.println("默认方法1");
        //method3();
    }

    public default void method2() {
        System.out.println("默认方法2");
       // method3();
    }

    /* private  void method3() {
        System.out.println("AAA");
        System.out.println("BBB");
    }*/
}
