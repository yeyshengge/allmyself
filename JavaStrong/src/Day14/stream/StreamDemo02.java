package Day14.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Stream<String> lsitstream = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream = set.stream();

        Map<String,Integer> map = new HashMap<>();
        Stream<String> stream1 = map.keySet().stream();
        Stream<Integer> stream2 = map.values().stream();

        String[] str= {"hello","word","java"};
        Stream<String> str1 = Stream.of(str);
        Stream<String> hello = Stream.of("hello", "word", "java");


    }
}
