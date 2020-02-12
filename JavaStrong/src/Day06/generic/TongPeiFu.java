package Day06.generic;

import java.util.ArrayList;
import java.util.List;

public class TongPeiFu {
    public static void main(String[] args) {



        //Integer extends Number extends Object

        List<?> list1 = new ArrayList<Object>();
        List<?> list2 = new ArrayList<Integer>();
        List<?> list3 = new ArrayList<Number>();

        // List<? extends Number> lsit5 = new ArrayList<Object>();
        List<? extends Number> lsit6 = new ArrayList<Integer>();
        List<? extends Number> lsit7 = new ArrayList<Number>();

        List<? super Number> list8 = new ArrayList<Number>();
        List<? super Number> list9 = new ArrayList<Object>();
        //List<? super Number> list0 = new ArrayList<Integer>();
    }
}
