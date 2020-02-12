package com.zps.annotion;

import org.springframework.stereotype.Component;

@Component("target")
public class targetImpl implements targetInter {

    @Override
    public void save() {
        System.out.println("save...running");
    }
}
