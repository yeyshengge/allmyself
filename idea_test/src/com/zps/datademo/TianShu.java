package com.zps.datademo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TianShu {
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date brithday = sdf.parse(s);
        long b = brithday.getTime();
        Date date = new Date();
        long nowdate = date.getTime();
        long tian = nowdate - b;
        System.out.println(tian / 1000 / 60 / 60 / 24);


    }
}