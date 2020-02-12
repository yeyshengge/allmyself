package com.itheima.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    @Test
    public void test01() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "18");
        /*map.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });*/



       /* Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (next.getKey().equals("name")) {
                map.remove("name");
            }
            System.out.println(next.getKey() + "=" + next.getValue());
        }*/

        /*for (Map.Entry<String, String> it : map.entrySet()) {
            if (it.getKey().equals("name")) {
               // map.remove(it.getKey());
            }
            System.out.println(it.getKey());
        }*/

        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> item = it.next();
            if (item.getKey().equals("name"))
                it.remove();
        }

        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println(item.getKey());
        }

    }
}
