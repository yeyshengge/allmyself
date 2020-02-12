package com.zps.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
 * LinkedHashMap底层是哈希表+链表
 *
 * */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("c", "c");
        map.put("b", "b");
        System.out.println(map);//{a=a, b=b, c=c}证明是无序的

        System.out.println("-----------------------");
        LinkedHashMap<String, String> linked = new LinkedHashMap<>();
        linked.put("a", "a");
        linked.put("c", "c");
        linked.put("b", "b");
        linked.put("d", "d");

        System.out.println(linked);//{a=a, c=c, b=b, d=d}有序
    }
}
