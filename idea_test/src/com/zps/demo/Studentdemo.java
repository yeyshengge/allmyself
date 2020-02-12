package com.zps.demo;

public class Studentdemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setAge("18");
        s1.setName("张翩笙");
        s1.show();

        Student s2= new Student("何虎","18");
        s2.show();
    }


}
