package com.zps.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before() {
        System.out.println("前置方法");
    }
    public void afterRunning() {
        System.out.println("后置方法");
    }
    public Object around(ProceedingJoinPoint jt) throws Throwable {
        System.out.println("环绕前");
        Object obj = jt.proceed();
        System.out.println("环绕后");
        return obj;
    }

    public void error(){
        System.out.println("异常");
    }

    public void last(){
        System.out.println("必须执行");
    }

}
