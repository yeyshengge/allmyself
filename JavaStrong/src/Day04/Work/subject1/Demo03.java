package Day04.Work.subject1;

import Day01.Work.D;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo03 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�޸ĵ�ǰString����ʽ
        String f = sdf.format(d);
        System.out.println(f);


    }
}
