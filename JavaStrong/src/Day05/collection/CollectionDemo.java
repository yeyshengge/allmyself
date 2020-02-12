package Day05.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
Collection :单列集合(顶层接口)
           : List(接口)  元素有序，能存储重复的元素  1，ArrayList集合跟LinkedList
           : Set(接口)   元素无序，不能存储重复元素  1，HashSet集合跟TreeSet集合
      Map  : 双列集合
           :HashMap
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("Hello");
        c.add("Java");

        System.out.println(c);

    }
}
