package Day06.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
set集合不能存储重复元素，没有索引，不能用for循环遍历。存储顺序不确定
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("i");
        set.add("love");
        set.add("u");
        set.add("love");//存储无效
        System.out.println(set);//[love, u, i]
        for(String s:set){
            System.out.println(s);
        }
        Iterator<String> it =set.iterator();
        while(it.hasNext()){
            String next = it.next();
            System.out.println(next);
        }

    }
}
