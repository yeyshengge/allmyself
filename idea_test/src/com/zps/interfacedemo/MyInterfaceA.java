package com.zps.interfacedemo;

public interface MyInterfaceA {


    public abstract void methodA();

    public abstract void methodC();

    public default void methodE() {
        System.out.println("EEE");
    }

}



