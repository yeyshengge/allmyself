package com.zps.Set;

import java.util.HashSet;
//存储元素会调用Hashcode跟equals方法
public class HashDemo {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        String s1 = new String("abc");
        String s2 = new String("abc");
        set.add(s1);
        set.add(s2);
        set.add("通话");
        set.add("重地");
        set.add("abc");
        System.out.println(set);
    }
}
