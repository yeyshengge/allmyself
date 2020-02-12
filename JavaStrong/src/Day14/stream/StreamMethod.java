package Day14.stream;

import java.util.ArrayList;

/*
Stream<T> limit​(long maxSize) 返回由此流的元素组成的流，截短长度不能超过 maxSize 。
Stream<T> skip​(long n) 在丢弃流的第一个 n元素后，返回由该流的剩余元素组成的流。
 */
public class StreamMethod {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        //需求一：取前三个元素输出
        list.stream().limit(3).forEach(System.out::println);
        System.out.println("--------");
        //需求二：跳过三个元素，把剩下的输出
        list.stream().skip(3).forEach(System.out::println);
        System.out.println("--------");
        //需求三：跳过二个元素，把剩下的前两个打印出来
        list.stream().skip(2).limit(2).forEach(System.out::println);
    }
}
