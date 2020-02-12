package Day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //日期的格式化，，，为文本
        //String---》Date
        /*Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();//无参构造方法
        String str = sdf.format(d);
        System.out.println(str);//19-8-27 下午4:54  无参构造方法默认的字符串类型

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//有参
        String str2 = sdf2.format(d);
        System.out.println(str2);

        //日期的解析，String--->Date;
        *//*String str3 = "1998年05月01日 07:20:50";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");*//*
        String str3 = "19980501072050";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
        Date s2 = sdf3.parse(str3);
        System.out.println(s2);*/


        //Date ---> String
        Date d = new Date();
        d.setTime(111223321122l);
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        String str1 = sdf1.format(d);
        System.out.println(str1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2 = sdf2.format(d);
        System.out.println(str2);


        //String--->Date
        String str3 = "1999-07-89 10:55:88";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf3.parse(str3);
        System.out.println(d1);



    }
}
