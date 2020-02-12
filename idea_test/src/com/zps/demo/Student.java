package com.zps.demo;

public class Student {

    private String name;
    private String age;



    public Student() {
        System.out.println("无参构造方法");
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}

