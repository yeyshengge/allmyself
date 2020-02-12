package com.zps.interfacedemo;

public interface MyinterfaceDefault {


    public abstract  void method();

   // public abstract  void method2();

    public default void method3(){
        System.out.println("新加默认方法");
    }
}
