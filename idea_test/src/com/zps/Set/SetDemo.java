package com.zps.Set;

/*
* 不可以存储重复元素,无序的
* 没有索引，不能用for循环遍历
* 多线程，底层是一个哈希表结构：查询非常快
* */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(9);
        set.add(1);
        System.out.println(set);
        //迭代器遍历set集合
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);

        }System.out.println("===============");
        //增强for循环
        for (Integer integer : set) {
            System.out.println(integer);
        }

    }


}
