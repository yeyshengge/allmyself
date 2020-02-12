package com.zps.CollectionDemo;

import java.util.ArrayList;
import java.util.Collection;
//Collection中通用的方法
public class CollectionMain {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);

        //增加元素add();
        coll.add("444");
        coll.add("DSAD");
        coll.add("啊");
        System.out.println(coll);

        //删除指定元素
        coll.remove("444");
        System.out.println(coll);
        //删除一个不存在的返回false
        boolean a = coll.remove("adadd000");
        System.out.println(a);
        System.out.println(coll);

        //是否包含元素
        boolean s = coll.contains("s");
        System.out.println(s);

        //集合元素是否为空
        boolean empty = coll.isEmpty();
        System.out.println(empty);

        //集合元素个数
        int size = coll.size();
        System.out.println(coll);
        System.out.println(size);

        //public object[] toArray()
        //把集合变为数组
        Object[] objects = coll.toArray();
        for(int i=0;i<objects.length;i++){
            System.out.println(objects[i]);
        }

        //清除集合中的数据
        coll.clear();
        System.out.println(coll);


    }
}
