package com.zps.student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        for (; ; ) {
            System.out.println("----------欢迎来到学生管理系统----------");
            System.out.println("1.增加学生信息");
            System.out.println("2.查询所有学生");
            System.out.println("3.修改学生信息");
            System.out.println("4.删除学生信息");
            System.out.println("5.退出");
            System.out.println("请输入你要进行的操作：");
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            if (number == 1) {
                Addstudent(array);
                System.out.println("录入学生信息成功");
                Chastudent(array);
            } else if (number == 2) {
                Chastudent(array);
            } else if (number == 3) {
                Gaistudent(array);

            } else if (number == 4) {
                Delstudent(array);
            } else if (number == 5) {
                System.out.println("退出成功，谢谢使用。");
                System.exit(0);
            } else {
                System.out.println("您的输入有误，请重新输入");
            }
        }

    }

    public static void Addstudent(ArrayList<Student> array) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生学号");
        String id = input.nextLine();
        System.out.println("请输入学生姓名");
        String name = input.nextLine();
        System.out.println("请输入学生年龄");
        String age = input.nextLine();
        System.out.println("请输入学生地址");
        String address = input.nextLine();
        Student ad = new Student();
        ad.setId(id);
        ad.setName(name);
        ad.setAge(age);
        ad.setAddress(address);
        array.add(ad);
    }

    public static void Chastudent(ArrayList<Student> array) {
        System.out.println("学号" + "    " + "姓名" + "    " + "年龄" + "    " + "地址");
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            System.out.println(s.getId() + "    " + s.getName() + "    " + s.getAge() + "    " + s.getAddress());
        }
    }

    public static void Gaistudent(ArrayList<Student> array) {
        System.out.println("请输入要修改学生的学号：");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        for (int i = 0; i < array.size(); i++) {
            Student gd = array.get(i);


            //  System.out.println(gd.getId() + "dad");
            if (s.equals(gd.getId()) == true) {
                System.out.println("要修改的姓名：");
                Scanner input1 = new Scanner(System.in);
                String s1 = input.nextLine();
                System.out.println("要修改的年龄：");
                Scanner input2 = new Scanner(System.in);
                String s2 = input.nextLine();
                System.out.println("要修改的地址：");
                Scanner input3 = new Scanner(System.in);
                String s3 = input.nextLine();
                gd.setName(s1);
                gd.setAge(s2);
                gd.setAddress(s3);
                // array.add(gd);
                System.out.println("修改学生信息成功");
            } else {
                System.out.println("没有此学号。");
            }
        }
    }

    public static void Delstudent(ArrayList<Student> array) {
        System.out.println("请输入要修改学生的学号：");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

            Student gd1 = array.get(0);
            if (s.equals(gd1.getId()) == true) {
                for (int j = 0; j < array.size(); j++)
                    array.remove(j);
                System.out.println("删除成功");
            } else {
                System.out.println("你的输入有误");
            }
        }
    }



