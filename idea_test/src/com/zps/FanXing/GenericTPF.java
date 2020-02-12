package com.zps.FanXing;

import com.zps.NeiBuLei.outer;

import java.util.ArrayList;
import java.util.Iterator;

//通配符
public class GenericTPF {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);

        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("dada");
        arr1.add("硕大的");

        printArray(arr);
        printArray(arr1);
    }

    //定义一个方法，遍历所有集合，这时我们不知道集合中使用什么数据类型，可以使用泛型来接收
    public static void printArray(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            System.out.println(next);
        }

    }

}
