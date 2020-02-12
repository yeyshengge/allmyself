package Day05.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        // System.out.println(list);
        ListIterator<String> s = list.listIterator();
        while (s.hasNext()) {
            String next = s.next();
        }
        //此方法会倒着遍历集合，必须把集合顺着来一遍，才能倒着输出来
        while (s.hasPrevious()) {
            String s2 = s.previous();
            System.out.println(s2);
        }
        //System.out.println(list);
    }
}
