package Day15.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Integer i1 = 9527;
        Integer i2 = 9527;
        System.out.println(i1 == i2);       //false
        System.out.println(i1.equals(i2));  //ture

        System.out.println("------------------");

        Integer i3 = new Integer(123);
        Integer i4 = new Integer(123);
        System.out.println(i3 == i4);             //false
        System.out.println(i3.equals(i4));        //true

        System.out.println("------------------");

        Integer i5 = 10;
        Integer i6 = 10;
        System.out.println(i5 == i6);        //true
        System.out.println(i5.equals(i6));   //true

        System.out.println("------------------");

        Character c1 = '中';
        Character c2 = '中';
        System.out.println(c1 == c2);              //false
        System.out.println(c1.equals(c2));         //true


        System.out.println("------------------");

        Character c3 = 'a';
        Character c4 = 'a';
        System.out.println(c3 == c4);           //true
        System.out.println(c3.equals(c4));      //true


    }
}
