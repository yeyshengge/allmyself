package com.zps.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class Demo {
    public static void main(final String[] args) {
        final Strong s = new Strong();
        final targetImpl t = new targetImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                s.Before();
                Object invoke = method.invoke(t, objects);
                s.After();
                return invoke;
            }
        });
        targetImpl o = (targetImpl) enhancer.create();
        o.save();

    }
}
