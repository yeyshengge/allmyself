package com.zps.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {
    public static void main(final String[] args) {
        final Strong s = new Strong();
        final targetImpl target = new targetImpl();
        targetInter proxy = (targetInter) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                s.Before();
                Object invoke = method.invoke(target, objects);
                s.After();
                return invoke;

            }
        });
        proxy.save();
    }
}
