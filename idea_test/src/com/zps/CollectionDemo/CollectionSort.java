package com.zps.CollectionDemo;

import java.util.ArrayList;
import java.util.Collections;

//sort方法，存储元素必须实现comparable，重写compareTo方法
//自定义比较的规则（比较年龄）
//return this.getAge()- s.getAge();//年龄降序
//return  s.getAge() - this.getAge();//年龄升序

public class CollectionSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);

        list.add(4);
        //Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);//默认升序
        //System.out.println(list);

        ArrayList<String> list01 = new ArrayList<>();
        list01.add("a");
        list01.add("c");
        list01.add("b");


        list01.add("d");
        Collections.sort(list01);//默认升序
        //Collections.shuffle(list);
        //System.out.println(list01);

        ArrayList<Person> list02 = new ArrayList<>();
        list02.add(new Person("zsdad", 28));
        list02.add(new Person("gd", 39));
        list02.add(new Person("dgfdg", 18));
        //System.out.println(list02);
        Collections.sort(list02);
        System.out.println(list02);
    }
}
