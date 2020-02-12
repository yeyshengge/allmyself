package com.zps.Map;




/*
* 遍历map集合的第二种方法
* Set<Map<k,v>>方法，获取一个set<key>集合
* Set<Map.Entry<String, Integer>> entries = map.entrySet();
* */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EntryDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("迪丽热巴", 18);
        map.put("古力娜扎", 19);
        map.put("马尔扎哈", 28);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> a = entries.iterator();
        while (a.hasNext()) {
            Map.Entry<String, Integer> next = a.next();
            System.out.println(next);
        }
        System.out.println("+++++++++++++++++++++++");
        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            System.out.println(value);
        }
    }

}
