package com.zps.annotion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.zps.annotion.*.*(..))")
    public void cutpoint(){}

    @Before("cutpoint()")
    public void before() {
        System.out.println("前置方法");
    }

    public void afterRunning() {
        System.out.println("后置方法");
    }

    @Around("MyAspect.cutpoint()")
    public Object around(ProceedingJoinPoint jt) throws Throwable {
        System.out.println("环绕前");
        Object obj = jt.proceed();
        System.out.println("环绕后");
        return obj;
    }

    public void error() {
        System.out.println("异常");
    }

    public void last() {
        System.out.println("必须执行");
    }

}
