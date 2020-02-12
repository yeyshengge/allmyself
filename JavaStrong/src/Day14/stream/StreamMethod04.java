package Day14.stream;

import java.util.ArrayList;

/*
forEarch
count()返回元素数目
 */
public class StreamMethod04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");

        long count = list.stream().count();
        System.out.println(count);
    }
}
