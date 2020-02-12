package Day14.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 collect​(Supplier<R> supplier, BiConsumer<R,? super T> accumulator, BiConsumer<R,R> combiner)
 对此流的元素执行 mutable reduction操作。
<R,A> R collect​(Collector<? super T,A,R> collector) 使用 Collector对此流的元素执行 mutable reduction操作。
toList
toSet
toMap
 */
public class StreamMethod05 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");

        //需求一：得到名字为3个字的流
        Stream<String> ss = list.stream().filter(s -> s.length() == 3);
        //把流收集到集合并遍历
        List<String> collect = ss.collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(33);
        set.add(35);
        //需求三：得到年龄大于25的流
        Stream<Integer> sss = set.stream().filter(s -> s > 25);
        //把上数据流收集到set集合中
        Set<Integer> collect1 = sss.collect(Collectors.toSet());
        for (Integer i : collect1) {
            System.out.println(i);
        }
        String[] str = {"林青霞,30", "张曼玉,35", "王祖贤,33", "柳岩,25"};
        //得到字符串的年龄大于28的流
        Stream<String> ssss = Stream.of(str).filter(s -> Integer.parseInt(s.split(",")[1]) > 28);
        //把上述流添加到Map集合并遍历，姓名作键，年龄作值
        Map<String, String> collect2 = ssss.collect(Collectors.toMap(s -> s.split(",")[0], s -> s.split(",")[1]));
        Set<String> strings = collect2.keySet();
        System.out.println("---------");
        for (String sssss : strings) {
            System.out.println(sssss + collect2.get(sssss));
        }
    }
}
