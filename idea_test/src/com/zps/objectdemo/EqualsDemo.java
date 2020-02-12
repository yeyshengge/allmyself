package com.zps.objectdemo;

import java.util.Objects;

public class EqualsDemo {


    public static void main(String[] args) {
        Person p1 = new Person("迪丽热巴", 19);
        Person p2 = new Person("迪丽热巴", 19);
       // System.out.println(p1.equals(p2));
       // System.out.println(p1==p2);
        String a =null;
        String b =null;

        System.out.println(Objects.equals(a,b));

    }
}
