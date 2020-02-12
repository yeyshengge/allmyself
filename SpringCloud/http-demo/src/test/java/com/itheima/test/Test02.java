package com.itheima.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test02 {

    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");


        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> item = it.next();
            it.remove();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key" + entry.getKey() + "  value:" + entry.getValue());
        }

    }

    @Test
    public void test2() {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "2");
        map.put(4, "4");

        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            if (entry.getKey() % 2 == 0) {
//                System.out.println("To delete key " + entry.getKey());
                it.remove();
                System.out.println(entry.getKey());
//                System.out.println("The key " + +entry.getKey() + " was deleted");
            }

        }
    }
}
