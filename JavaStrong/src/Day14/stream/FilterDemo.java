package Day14.stream;

import Day10.demo.SystemOut;

import java.util.ArrayList;

/*
Stream<T> filter​(Predicate<? super T> predicate) 返回由与此给定谓词匹配的此流的元素组成的流。  (过滤)
 */
public class FilterDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        //需求一：以张开头的打印在控制台
        list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
        System.out.println("--------");
        //需求二：集合中长度为3的元素打印出来
        list.stream().filter(s -> s.length() == 3).forEach(System.out::println);
        System.out.println("--------");
        //需求三：以张开头的，长度为3的元素打印出来
        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
    }
}
