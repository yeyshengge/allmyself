/*
package com.zps.job;

import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

*/
/**
 * Created by zps on 2019/12/25 15:25
 *//*

public class Test {
    public static void main(String[] args) throws Exception {

        UpdateJob updateJob = new UpdateJob();
        Method method = updateJob.getClass().getDeclaredMethod("test");
        Scheduled scheduled = method.getAnnotation(Scheduled.class);
        String cron = scheduled.cron();
        System.out.println(cron);
        InvocationHandler h = Proxy.getInvocationHandler(scheduled);
        Field hFiled = h.getClass().getDeclaredField("memberValues");
        hFiled.setAccessible(true);
        Map memberValues = (Map) hFiled.get(h);
        memberValues.put("cron","* * * * * ?");
    }
}
*/
