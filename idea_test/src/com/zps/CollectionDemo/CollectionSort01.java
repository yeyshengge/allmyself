package com.zps.CollectionDemo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Comparator跟Comparable的区别
//Comparable实现Comparator接口，重写compareTo方法
//Comparator:相当于找一个第三方裁判比较
public class CollectionSort01 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        Collections.sort(list, new Comparator<Integer>() {
            //重写比较方法
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;//升序
            }
        });
        System.out.println(list);

    }
}
