package Day05.list;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        List<String> c = new ArrayList<String>();

        c.add("aa");
        c.add("bb");
        c.add("dd");

        System.out.println(c);

        for (int i = 0; i < c.size(); i++) {
            for (int j = i; j < c.size(); j++) {
                if (c.get(i) == c.get(j) && i != j) {
                    c.remove(j);
                    j--;
                }
            }
        }
        System.out.println(c);
    }
}