package Day14.demo;

import java.util.function.Function;

public class FunctionDemo01 {
    public static void main(String[] args) {
        method("林青霞,30", s -> Integer.parseInt(s.split(",")[1]) + 70);


    }

    private static void method(String s, Function<String, Integer> f) {
        Integer i = f.apply(s);
        System.out.println(i);
    }
}
