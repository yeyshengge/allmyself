package Day05.list;

import java.util.ArrayList;

public class Demo03 {
    public static void main(String[] args) {
        ArrayList<String> c = new ArrayList<String>();

        c.add("hello");
        c.add("world");
        c.add("world");
        c.add("java");
        c.add("java");
        c.add("java");

        ArrayList<String> c1 = new ArrayList<>();
        c1.addAll(c);
        System.out.println(c1);

    }
}
