package com.zps.proxy.cglib;

public class Strong {

    public void Before() {
        System.out.println("前置");

    }

    public void After() {
        System.out.println("后置");
    }
}
