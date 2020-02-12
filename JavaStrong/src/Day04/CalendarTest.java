package Day04;

import java.util.Calendar;

/*
二月天
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2000,2,1);
        c.add(Calendar.DATE,-1);
        System.out.println(c.get(Calendar.DATE));

    }
}
