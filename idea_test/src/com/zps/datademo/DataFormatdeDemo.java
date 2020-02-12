package com.zps.datademo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatdeDemo {
    public static void main(String[] args) throws ParseException {
        demo01();
        demo02();
    }

    //把日期格式化为文本
    public static void demo01() {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        String d = sdf.format(date);
        System.out.println(date);
        System.out.println(d);
    }

    //文本解析为日期格式
    public static void demo02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date data=sdf.parse("2019年08月09日 09时40分50秒");
        System.out.println(data);
    }

}
