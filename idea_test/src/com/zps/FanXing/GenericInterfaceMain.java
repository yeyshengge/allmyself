package com.zps.FanXing;

import com.zps.NeiBuLei.outer;


public class GenericInterfaceMain {
    public static void main(String[] args) {
//第一种在接口中定义
        GenericInterfaceImpl genericInterface = new GenericInterfaceImpl();
        genericInterface.method("dada");
//第二种方法可以在定义对象时声明，
        GenericInterfaceImpl2<Integer> genericInterfaceImpl2 = new GenericInterfaceImpl2<>();
        genericInterfaceImpl2.method(11);
        GenericInterfaceImpl2<Double> genericInterfaceImpl21 = new GenericInterfaceImpl2<>();
        genericInterfaceImpl21.method(8.1);
    }
}
