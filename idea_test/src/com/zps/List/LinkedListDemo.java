package com.zps.List;

import java.util.LinkedList;

/*
 * 底层是链表结构，查询慢，增删快。
 * 里面包含了大量操作队尾，对首的方法
 * linkedlist不能使用多态
 * */
public class LinkedListDemo {
    public static void main(String[] args) {
        //show();
        //show2();
        show3();
    }

    //增加元素
    public static void show() {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);
        //队头插入元素
        linked.addFirst("www.");//同linked.push()一样的
        System.out.println(linked);

        //队尾插入元素
        linked.addLast("com");
        System.out.println(linked);


    }
    //获取第一，最后一个元素
    public static void show2() {
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");

        linked.clear();//NoSuchElementException报错

        while (!linked.isEmpty()) {//判断是否含有元素
            System.out.println(linked);
            String first = linked.getFirst();//获取第一个元素
            System.out.println(first);
            String last = linked.getLast();//获取最后一个元素
            System.out.println(last);
        }
    }
    public static void show3(){
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);
        String s = linked.removeFirst();
        System.out.println("移除的第一个人元素："+s);
        String s1 = linked.removeLast();
        System.out.println("移除的最后一个元素"+s1);
        System.out.println("剩余元素"+linked);

    }
}
