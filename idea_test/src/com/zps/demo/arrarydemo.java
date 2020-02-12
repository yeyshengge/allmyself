package com.zps.demo;

import java.util.ArrayList;

public class arrarydemo {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("hello");
        array.add("word");
        array.add("java");
        array.add(3,"ss");
        System.out.println(array);
        //array.remove(3);
        System.out.println(array.remove("word"));
        array.set(2,"sssasd");
        System.out.println(array);
        System.out.println(array.size());
        //IndexOutOfBoundsException
        System.out.println(array.get(3));
    }
}
