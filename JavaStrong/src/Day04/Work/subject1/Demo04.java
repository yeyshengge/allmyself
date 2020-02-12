package Day04.Work.subject1;
//四:使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日。

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo04 {
    public static void main(String[] args) {
        String str = "2018-03-04";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf2.parse(str);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            String s = sdf.format(d);
            System.out.println(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
