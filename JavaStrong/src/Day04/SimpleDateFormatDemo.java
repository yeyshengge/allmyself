package Day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //���ڵĸ�ʽ��������Ϊ�ı�
        //String---��Date
        /*Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();//�޲ι��췽��
        String str = sdf.format(d);
        System.out.println(str);//19-8-27 ����4:54  �޲ι��췽��Ĭ�ϵ��ַ�������

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");//�в�
        String str2 = sdf2.format(d);
        System.out.println(str2);

        //���ڵĽ�����String--->Date;
        *//*String str3 = "1998��05��01�� 07:20:50";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");*//*
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
