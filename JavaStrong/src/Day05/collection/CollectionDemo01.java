package Day05.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo01 {
    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList<>();
        coll.add(11);
        coll.add(22);
        coll.add(33);
        coll.add(44);
        System.out.println(coll);

        //boolean remove(Object o)删除元素
        boolean b= coll.remove(11);
        System.out.println(b);
        System.out.println(coll);

        //boolean contains(Obj o)判断是否含有此元素
        boolean c= coll.contains(54);
        System.out.println(c);

        //int size()集合长度
        System.out.println(coll.size());

        //boolean isEmpty()判断是否为空
        boolean d = coll.isEmpty();
        System.out.println(d);

        //void claer()清除数组中的所有集合
        coll.clear();
        System.out.println(coll.size());

        System.out.println("--------");
        coll.add(11);
        coll.add(22);
        coll.add(33);
        coll.add(44);
        System.out.println(coll);

        Iterator<Integer> it = coll.iterator();
        while (it.hasNext()){
            int next = it.next();
            System.out.println(next);
        }
    }
}
