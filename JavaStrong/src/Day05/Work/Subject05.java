package Day05.Work;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
5、给定以下代码，请定义方法public static int listTest(Collection<String> list,String s)
统计集合中指定元素出现的次数，
如"a":2,"b": 2,"c" :1, "xxx":0。
Collection<String> list = new ArrayList<>();
	list.add("a");
	list.add("a");
	list.add("b");
	list.add("b");
	list.add("c");
	System.out.println("a:"+listTest(list, "a"));
	System.out.println("b:"+listTest(list, "b"));
	System.out.println("c:"+listTest(list, "c"));
	System.out.println("xxx:"+listTest(list, "xxx"));

 */
public class Subject05 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:" + listTest(list, "a"));
        System.out.println("b:" + listTest(list, "b"));
        System.out.println("c:" + listTest(list, "c"));
        System.out.println("xxx:" + listTest(list, "xxx"));
        ArrayList<String> s=(ArrayList<String>)list;
    }

    public static int listTest(Collection<String> list, String s) {
        int index = 0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (s.equals(it.next())) {
                index++;
            }
        }
        return index;
    }
}
