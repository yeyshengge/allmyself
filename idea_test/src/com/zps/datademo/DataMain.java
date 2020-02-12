package com.zps.datademo;


import com.zps.NeiBuLei.Demo01;

import java.util.Date;

public class DataMain {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());//返回08:00:00 CST 1970距今多少毫秒
        Demo01();
        Demo02();

    }

    public static void show() {
        System.out.println();
    }

    public static void Demo01() {
        Date data = new Date();
        System.out.println(data);
    }

    private static void Demo02() {
        Date data = new Date(0L);
        System.out.println(data);

    }

}



