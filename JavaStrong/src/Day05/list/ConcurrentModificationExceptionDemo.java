package Day05.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*

ConcurrentModificationException
并发修改异常
案例：如果集合中有142这个元素，就把152加入到集合
 */
public class ConcurrentModificationExceptionDemo {
    public static void main(String[] args) {

        List<Integer> list =new ArrayList<>();
        list.add(127);
        list.add(142);
        list.add(124);
        list.add(151);

       /* Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            *//*
            ConcurrentModificationException
            因为实际修改次数跟预期修改次数不一致，
             *//*
            Integer next = it.next();
            if(next.equals(142)){
                list.add(152);//实际修改次数会+1;
            }
        }
        System.out.println(list);*/


        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(142)){
                list.add(152);//实际修改次数会+1;
            }
        }
        System.out.println(list);
    }
}
