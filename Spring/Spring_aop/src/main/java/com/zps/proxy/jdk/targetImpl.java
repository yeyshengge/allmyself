package com.zps.proxy.jdk;

public class targetImpl implements targetInter {
    @Override
    public void save() {
        System.out.println("save...running");
    }
}
