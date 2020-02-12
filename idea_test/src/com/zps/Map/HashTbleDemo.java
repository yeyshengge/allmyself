package com.zps.Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/*
* 同步的，单线程，速度慢，安全
* 底层是一个hash表
*之前学的所有集合可以存储空值，但是Hsahtable不可以
* */
public class HashTbleDemo {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put(null,"a");
        map.put("a",null);
        System.out.println(map);//{null=a, a=null}
        Set<String> s = map.keySet();
        Iterator<String> it = s.iterator();
        while ((it.hasNext())){
            String next = it.next();
            System.out.println(next+"-->"+map.get(next));
        }
        System.out.println("------------------------");
        Hashtable<String,String> table = new Hashtable<>();
        table.put(null,null);
        System.out.println(table);//NullPointerException报错
    }
}
