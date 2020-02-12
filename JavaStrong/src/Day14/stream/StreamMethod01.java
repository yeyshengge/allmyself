package Day14.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
static <T> Stream<T> concat​(Stream<? extends T> a, Stream<? extends T> b)
创建一个懒惰连接的流，其元素是第一个流的所有元素，后跟第二个流的所有元素。
Stream<T> distinct​() 返回由该流的不同元素（根据 Object.equals(Object) ）组成的流。
 */
public class StreamMethod01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        //需求一：取前4个元素组成一个流
        Stream<String> m1 = list.stream().limit(4);
        System.out.println("--------");
        //需求二：跳过2个元素，把剩下的组成一个流
        Stream<String> m2 = list.stream().skip(2);
        System.out.println("--------");
        //需求三：合并前两个流，在控制台输出
        //Stream.concat(m1,m2).forEach(System.out::println);
        System.out.println("--------");
        //需求四：合并前两个流，在控制台输出，且元素不能重复
        Stream.concat(m1,m2).distinct().forEach(System.out::println);
    }
}
