package Day04;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        //System.out.println(cal);
       /* int year =cal.get(Calendar.YEAR)+1;
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DATE);
        System.out.println(year+"��"+month+"��"+day+"��");*/


        cal.set(3000,12,6);//���õ�ǰ�����ڸ�ʽ
        int year =cal.get(Calendar.YEAR)+1;
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DATE);
        System.out.println(year+"��"+month+"��"+day+"��");

        cal.add(Calendar.MONTH,10);
        int year1 =cal.get(Calendar.YEAR)+1;
        int month1 = cal.get(Calendar.MONTH)+1;
        int day1 = cal.get(Calendar.DATE);
        System.out.println(year1+"��"+month1+"��"+day1+"��");
        System.out.println("======================");

        System.out.println(System.currentTimeMillis());


    }
}
