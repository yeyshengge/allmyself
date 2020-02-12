package Day15.work.subject03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {
    public static void main(String[] args) throws ParseException {
        long now = System.currentTimeMillis();

        String str = "1998-05-01";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long past = sdf.parse(str).getTime();

        System.out.println((now - past) * 1.0 / 1000 / 60 / 60 / 24);

    }
}
