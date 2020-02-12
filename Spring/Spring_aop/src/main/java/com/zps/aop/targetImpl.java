package com.zps.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class targetImpl implements targetInter {

    @Override
    public void save() {
        System.out.println("save...running");
        //int a=3/0;
    }
}
