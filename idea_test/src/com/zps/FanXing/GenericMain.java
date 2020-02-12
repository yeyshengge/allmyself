package com.zps.FanXing;

public class GenericMain {
    public static void main(String[] args) {
        GenericClass gc = new GenericClass();
        gc.setName("sadds");
        Object obj = gc.getName();

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(1);
        Integer a = gc2.getName();
        System.out.println(a);

        GenericClass<String> gc3 = new GenericClass<>();
        gc3.setName("在 ");
        System.out.println(gc3.getName());


    }
}
