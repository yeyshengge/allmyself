package com.zps.interfacedemo;

public  class demo03 implements MyInterfaceA,MyInterfaceB {

    @Override
    public void methodA() {
        System.out.println("重写A");
    }

    @Override
    public void methodB() {
        System.out.println("重写B");
    }

    @Override
    public void methodC() {
        System.out.println("重写C");
    }

    @Override
    public void methodD() {
        System.out.println("重写D");
    }

    @Override
    public void methodE() {
        System.out.println("重写E");
    }
}
