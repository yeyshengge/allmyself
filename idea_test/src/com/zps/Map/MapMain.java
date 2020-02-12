package com.zps.Map;

/*
 * Map<k,v>双列集合，一个元素包含两个值
 * Map中key跟value的数据类型可以相同也可以不同
 * key不可以重复，value可以重复，key跟value是一一对应的
 * */


/*
 * HashMap集合底层是哈希表，查询速度特别快
 * JDK1.8之前：数组+单向链表
 * 之后：数组+单向链表/红黑树（链表长度超过8）
 * HashMap 无序集合，顺序可能不一样
 * */

/*
 * LinkedHashMapDemo : 底层是哈希表+链表（保持迭代的顺序）
 * LinkedHadhMap : 集合有序，存储元素跟取出元素顺序一样
 * */

import java.util.HashMap;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {

        //show01();
        //show02();
        //show03();
        show04();
    }

    //增加元素
    public static void show01() {
        Map<String, String> map = new HashMap<>();
        String a = map.put("李晨", "范冰冰");//map.put(k,v)增加元素
        System.out.println(a);//key不重复，返回null
        String b = map.put("李晨", "范冰冰2");
        System.out.println(b);//key重复，新value值替换旧value值，并返回旧值（范冰冰）
        System.out.println(map);//{李晨=范冰冰2}

        map.put("冷风", "龙小云");
        map.put("杨过", "小龙女");
        map.put("尹志平", "小龙女");
        System.out.println(map);
    }

    //删除元素
    //key存在,返回被删除的值对应的value，key不存在，返回null
    public static void show02() {
        Map<String, String> map = new HashMap<>();
        map.put("冷风", "龙小云1");
        map.put("杨过", "龙小云2");
        map.put("尹志平", "龙小云3");
        System.out.println(map);
        String s = map.remove("杨过");//返回龙小云2
        System.out.println(s);
        System.out.println(map);

    }

    //通过key获取value,key存在返回对应的value值，否则返回一个null
    public static void show03() {
        Map<String, String> map = new HashMap<>();
        map.put("冷风", "龙小云");
        map.put("杨过", "小龙女");
        map.put("尹志平", "小龙女");
        String s = map.get("冷风");
        System.out.println(s);//返回龙小云
        System.out.println();
        String s1 = map.get("张三");//返回nll
        System.out.println(s1);
    }

    //containsKey判断是否包含元素,包含返回ture，否则返回false
    public static void show04(){
        Map<String,Integer> map = new HashMap<>();
        map.put("迪丽热巴",18);
        map.put("古力娜扎",19);
        map.put("马尔扎哈",20);
        System.out.println(map);
        boolean b = map.containsKey("古力娜扎");
        System.out.println(b);
        boolean c = map.containsKey("杨幂");
        System.out.println(c);
        boolean b1 = map.containsValue(19);
        System.out.println(b1);

    }
}
