package Day04;


import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {

        Date d = new Date();
        System.out.println(d);
        for (int i =0,j=9;i<j;i++,j--){
            System.out.print(i+"*"+j+"="+i*j+" ");
        }
    }
}
