package com.zps.interfacedemo;

public interface MyInterfaceB {

    public abstract void methodB();

    public abstract void methodC();

    public abstract void methodD();

    public default void methodE() {
        System.out.println("EEE");
    }
}
