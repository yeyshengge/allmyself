package com.zps.FanXing;
//第二种方法
public class GenericInterfaceImpl2<I> implements  GenericInterface<I>{

    @Override
    public void method(I i) {
        System.out.println(i);
    }
}
