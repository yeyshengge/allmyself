package Day04;

import java.util.Date;

public class DateDemo01 {
    public static void main(String[] args) {
        Date d =new Date();
        long l =d.getTime();
        System.out.println(l);

        System.out.println("-----------");
        Date d2 = new Date();
        long time =1000*60*60*24;
        d2.setTime(time);
        System.out.println(d2);
    }
}
