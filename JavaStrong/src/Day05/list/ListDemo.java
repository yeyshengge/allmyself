package Day05.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*
List集合：有序集合，有索引，可以重复存储。
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("哪儿扎哈");
        list.add("迪丽热巴");//证明元素可以存储重复值
        //System.out.println(list);
        System.out.println("-----迭代器");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

    }
}
