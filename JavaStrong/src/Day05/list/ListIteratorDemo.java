package Day05.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        System.out.println(list);

        ListIterator<Integer> lit = list.listIterator();
        // 会往前遍历，网0索引前遍历，所以什么都没有，详情看demo02；
        while (lit.hasPrevious()) {
            Integer p = lit.previous();
            System.out.println(p);
        }
    }
}
