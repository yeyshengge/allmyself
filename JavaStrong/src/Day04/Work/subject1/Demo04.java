package Day04.Work.subject1;
//��:ʹ��SimpleDateFormat��,��2018-03-04ת��Ϊ2018��03��04�ա�

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo04 {
    public static void main(String[] args) {
        String str = "2018-03-04";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf2.parse(str);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
            String s = sdf.format(d);
            System.out.println(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
