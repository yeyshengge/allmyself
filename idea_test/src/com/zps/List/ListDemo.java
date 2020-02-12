package com.zps.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//List 接口 有序的， 有索引，可以重复
public class ListDemo {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();//多态
        arr.add("sdd");
        arr.add("12");
        arr.add("12");
        System.out.println(arr);//可以重复
        arr.add(2, "卓景京");//指定索引添加数据add(index,element)
        System.out.println(arr);
        String remove = arr.remove(2);//移除指定元素
        System.out.println("移除元素" + remove);
        System.out.println(arr);
        arr.set(0, "把0索引的元素换掉");//元素替换
        System.out.println(arr);

        //List集合遍历三种方式
        //普通for循环
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);//get方法获取元素
            System.out.println(s);
        }
        System.out.println("=====================");
        //迭代器遍历
        Iterator<String> it = arr.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
        System.out.println("=====================");
        //增强for循环
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
