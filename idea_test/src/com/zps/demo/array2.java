package com.zps.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class array2 {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();

        as(array);
        as(array);
        as(array);
        bl(array);

    }

    //键盘录入数据
    public static void as(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        System.out.println("please int name:");
        String name = input.nextLine();
        System.out.println("please int age:");
        String age = input.nextLine();
        Student ss = new Student();
        ss.setName(name);
        ss.setAge(age);
        array.add(ss);
    }

    //遍历数组
    public static void bl(ArrayList<Student> array) {
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
    }

}
