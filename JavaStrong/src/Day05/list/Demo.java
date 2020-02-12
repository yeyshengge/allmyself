package Day05.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
ArrayList 底层数据结构是数组  查询快，增删慢
LinkedLsit 底层数据结构是链表  增删慢，查询快

 */
public class Demo {
    public static void main(String[] args) {

        List<Integer> list1= new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        for(Integer i:list1){
            System.out.println(list1.get(i));
        }

        System.out.println("----------------");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for(Integer i:list){
            System.out.println(list.get(i));
        }




    }
}
