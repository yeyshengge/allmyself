package com.zps.Map;

import java.util.*;

/*
 * Map集合遍历的第一种方法：通过找key，然后map.get(key)找values,
 * 其中两种方法：迭代器，跟增强for循环。
 *
 * */
//key.set返回HashMap中key的集合
//.values返回valuse的值
public class KeySetDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("迪丽热巴", 18);
        map.put("古力娜扎", 19);
        map.put("马尔扎哈", 18);
        System.out.println(map);
        Set<String> s = map.keySet();//注意：用set集合接受
        System.out.println(s);
        Collection<Integer> values = map.values();//注意：用Collection集合接受
        System.out.println(values);

        System.out.println("-----------迭代器遍历set集合-----------");

        //迭代器遍历set集合
        Iterator it = s.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Integer a = map.get(next);//map.get:获取key对应的values值
            System.out.println(next + "是" + a + "岁");
        }

        System.out.println("-----------增强for循环遍历-----------");

        //增强for循环遍历
        for (String s1 : s) {
            Integer a = map.get(s1);
            System.out.println(s1 + "的年龄是" + a + "岁");
        }

    }
}
