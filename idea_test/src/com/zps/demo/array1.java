package com.zps.demo;

import java.util.ArrayList;

public class array1 {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();

        Student s1 = new Student("张某", "18");
        Student s2 = new Student("李某", "19");
        Student s3 = new Student("刘某", "17");

        array.add(s1);
        array.add(s2);
        array.add(s3);
        //sSystem.out.println(array);
        bl(array);
    }

    public static void bl(ArrayList<Student> array) {
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getName()+","+s.getAge());
        }
    }


}



