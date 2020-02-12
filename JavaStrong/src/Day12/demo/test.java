package Day12.demo;

import Day04.DateUtils;

import javax.xml.crypto.Data;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        DateUtils du = new DateUtils();
        Date d = new Date();
        String str = du.dateToString(d, "yyyy/MM/dd HH:mm:ss");
        System.out.println(str);
    }
}
