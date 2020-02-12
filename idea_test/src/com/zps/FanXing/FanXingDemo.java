package com.zps.FanXing;

import java.util.ArrayList;
import java.util.Iterator;

public class FanXingDemo {
    public static void main(String[] args) {
        show();
        show1();
    }

    public static void show() {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add(111);
        //迭代器遍历集合
        Iterator it = list.iterator();
        while (it.hasNext()) {//判断是否有下一个元素
            Object next = it.next();
            System.out.println(next);
            String s = (String) next;//要做类型转换
            System.out.println(s.length());
        }
    }

    public static void show1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("sd");


        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();//不要做类型转换
            System.out.println(next);
        }
    }


}
