package com.zps.test;

public class Studentdemo {
    public static void main(String[] args) {
        Student s = new Student();

        s.setName("张翩笙");
        s.setAge(18);
        s.show();
        Student s2= new Student("何虎");
        s2.show();
        Student s3= new Student(18);
        s3.show();
    }
}
