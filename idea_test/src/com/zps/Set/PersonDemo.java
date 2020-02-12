package com.zps.Set;

import java.util.HashSet;

public class PersonDemo {
    public static void main(String[] args) {


        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("张一", 18);
        Person p2 = new Person("张一", 18);
        Person p3 = new Person("张一", 20);
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);


    }
}
