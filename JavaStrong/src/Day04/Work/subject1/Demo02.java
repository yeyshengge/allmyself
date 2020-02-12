package Day04.Work.subject1;

/*二:计算出自己来到这个世界上多少天*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo02 {
    public static void main(String[] args) throws ParseException {
        String str = "1998-05-23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date d1 = sdf.parse(str);//Data日期出来了
        //System.out.println(d1);

        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        long l = cal.getTimeInMillis();
        //System.out.println(l);
        // System.out.println(System.currentTimeMillis());
        long l2 = System.currentTimeMillis() - l;
        System.out.println(l2 * 1.0 / 1000 / 60 / 60 / 24);


    }

}

