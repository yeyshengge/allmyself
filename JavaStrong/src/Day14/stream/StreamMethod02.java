package Day14.stream;

import java.util.ArrayList;

/*
Stream<T> sorted​() 返回由此流的元素组成的流，根据自然顺序排序。
Stream<T> sorted​(Comparator<? super T> comparator) 返回由该流的元素组成的流，根据提供的 Comparator进行排序。
 */
public class StreamMethod02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("linqingxia");
        list.add("zhangmanyu");
        list.add("wangzuxian");
        list.add("liuyan");
        list.add("zhangmin");
        list.add("zhangwuji");

        //需求一：按照字母顺序吧数据在控制台输出
        //list.stream().sorted().forEach(System.out::println);
        //需求二：按照字母长度排序
        //list.stream().sorted((s1,s2)->s1.length()-s2.length()).forEach(System.out::println);

        /*list.stream().sorted((s1,s2)->{
            int n =s1.length()-s2.length();
            int m=n==0?s1.compareTo(s2):n;
            return m;
        }).forEach(System.out::println);*/

        list.stream().sorted((s1,s2)->s1.length()-s2.length()==0?s1.compareTo(s2):s1.length()-s2.length()).forEach(System.out::println);

    }
}
