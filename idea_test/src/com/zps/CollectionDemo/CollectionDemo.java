package com.zps.CollectionDemo;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionDemo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        //快速添加很多元素
        Collections.addAll(list,"d","e","f","g");
        System.out.println(list);
        //随机组合，打乱数组
        Collections.shuffle(list);
        System.out.println(list);
    }
}
