package Day04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("¿ªÊ¼");
        //exception();
        method();
        System.out.println("½áÊø");
    }


    public static void exception(){
        try {
            int[] arr ={1,2,3};
            System.out.println(arr[3]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());//java.lang.ArrayIndexOutOfBoundsException: 3
            System.out.println(e.getMessage());//3
            e.printStackTrace();
            /*java.lang.ArrayIndexOutOfBoundsException: 3
            at Day04.ExceptionDemo.exception(ExceptionDemo.java:14)
            at Day04.ExceptionDemo.main(ExceptionDemo.java:6)*/

        }
    }

    public static void method(){
        try {
            String str= "2018-05-23";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = sdf.parse(str);
            System.out.println(parse);
        }catch (ParseException e){
            e.printStackTrace();
        }

    }
}
