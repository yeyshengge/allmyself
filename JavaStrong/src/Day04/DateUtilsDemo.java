package Day04;

import java.text.ParseException;
import java.util.Date;

public class DateUtilsDemo {
    public static void main(String[] args) throws ParseException {
        DateUtils du = new DateUtils();
        Date d = new Date();
        String str = du.dateToString(d, "yyyy-MM-dd HH:mm:ss");
        System.out.println(str);

        String str2 = "2019/08/27 18:20:55";
        Date dd = du.stringToDate(str2, "yyyy/MM/dd HH:mm:ss");
        System.out.println(d);

    }

}
