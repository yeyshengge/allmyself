package Day01.util;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(i + "");
        }
        boolean contains = list.contains("25");
        System.out.println(contains);
    }
}
