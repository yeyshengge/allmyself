package Day05.Demo;


import Day15.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {

        /*
        迭代器 Iterator<String> iterator = c.iterator();
        如果在此声明了泛型，那么只能用String str = iterator.next();来接收
        如果没有声明，则用Object来接收
         */
        Collection c = new ArrayList();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()) {
            //循环里有两个next()方法，两个方法都会得到集合中的元素，由于第一个得到了第一个元素，所以
            //第二个next会得到下一个元素，故此题输出的便是输出一个跳一个，
            String s = iterator.next();
            String obj = iterator.next();
            System.out.println("--->" + obj);
        }

        //算术运算符右移n个相当于除以2的n次方
        //算术运算符左移n个相当于乘以2的n次方
        System.out.println(8 >> 2);
        System.out.println(16 >> 2);
        System.out.println(32 >> 2);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(111);
        list.add(222);
        list.add(333);
        list.add(444);
        list.add(555);
        for (int i : list) {
            i = 10;//在增强for循环里赋值不会改变集合中原有的值
            System.out.println("ssss" + i);
        }
        System.out.println(list);
    }
}





