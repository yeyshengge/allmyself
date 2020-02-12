package com.zps.test;

public class Student {
    //成员变量
    private String name;
    private int age;
    public Student(){
        System.out.println("无参构造方法");
    }
    public  Student(int age){
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;//this.name代表成员变量
    }

    public Student(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void show(){
        System.out.println(name+","+age);
    }
}