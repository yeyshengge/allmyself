package Day05.collection;
/*
boolean hasNext​() 如果迭代具有更多元素，则返回 true 。
E next​() 返回迭代中的下一个元素。
 */

import java.util.ArrayList;
import java.util.Collection;

import java.util.Iterator;


public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("Hello");
        coll.add("Word");
        coll.add("Java");
        System.out.println(coll);

        Iterator<String> it = coll.iterator();
       /* System.out.println(it.hasNext());//true 用来判断
        System.out.println(it.next());//返回下一个值
        System.out.println(it.next());*/

        while (it.hasNext()) {//如果it还有下一个元素(booleam类型)
            // System.out.println(it.next());
            String str = it.next();
            System.out.println(str);
        }
    }


}
