package Day14.stream;

import java.util.ArrayList;

/*
<R> Stream<R> map​(Function<? super T,? extends R> mapper) 返回由给定函数应用于此流的元素的结果组成的流。
IntStream mapToInt​(ToIntFunction<? super T> mapper) 返回一个 IntStream其中包含将给定函数应用于此流的元素的结果。
 */
public class StreamMethod03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("10");
        list.add("20");
        list.add("30");
        list.add("40");
        list.add("50");

        list.stream().map(Integer::parseInt).forEach(System.out::println);

        int sum = list.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(sum);

    }
}
