package com.zps.datademo;

import java.util.Calendar;
import java.util.Date;

//Calender抽象类，操作日历
public class CalendarDemo {
    public static void main(String[] args) {

        CalendarDemo a = new CalendarDemo();
        a.demo04();
    }

    public void demo01() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.MONTH);//西方的月份是0-11；
        System.out.println(year);
    }

    public void demo02() {
        Calendar c = Calendar.getInstance();
        //设置年
        c.set(Calendar.YEAR, 9999);
        c.set(Calendar.MONTH, 9);
        c.set(Calendar.DATE, 8);
        System.out.println(c);

        // c.set(8888,8,8);直接设置年月日
        int year = c.get(Calendar.YEAR);//西方的月份是0-11；
        System.out.println(year);
        int month = c.get(Calendar.MONTH);//西方的月份是0-11；
        System.out.println(month);
        int day = c.get(Calendar.DATE);//西方的月份是0-11；
        System.out.println(day);
    }

    public void demo03() {
        Calendar c = Calendar.getInstance();


        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, -12);
        //设置年
        // c.set(8888,8,8);直接设置年月日
        int year = c.get(Calendar.YEAR);//西方的月份是0-11；
        System.out.println(year);
        int month = c.get(Calendar.MONTH);//西方的月份是0-11；
        System.out.println(month);
        int day = c.get(Calendar.DATE);//西方的月份是0-11；
        System.out.println(day);
    }


    public void demo04() {
        Calendar c = Calendar.getInstance();

        Date time = c.getTime();
        System.out.println(time);

    }
}
