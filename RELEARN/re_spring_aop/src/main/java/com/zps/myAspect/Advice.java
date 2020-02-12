package com.zps.myAspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advice {
    @Before("execution(void com.zps.Service.impl.*.*(..))")
    public void before() {
        System.out.println("前置方法");
    }
}
