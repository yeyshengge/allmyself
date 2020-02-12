package Day14.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("ddd");
        list.add("cc");
        list.add("aaaaa");
        list.add("b");

        System.out.println("排序前" + list);
        Collections.sort(list, getComparator());
        System.out.println("排序后" + list);
    }

    private static Comparator<String> getComparator() {
       /* Comparator<String> co = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        };
        return co;*/
       /*return new Comparator<String>() {
           @Override
           public int compare(String s, String t1) {
               return s.length() - t1.length();
           }
       };*/
       /* Comparator<String> co = (String s, String t1) -> {
            return s.length() - t1.length();
        };
        return co;*/
       //最简单的
       return (s,t1)->s.length()-t1.length();


    }
}
