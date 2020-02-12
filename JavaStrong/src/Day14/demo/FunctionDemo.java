package Day14.demo;

import java.util.function.Function;

/*
default <V> Function<T,V> andThen​(Function<? super R,? extends V> after)
返回一个组合函数，首先将该函数应用于其输入，然后将 after函数应用于结果。
R apply​(T t) 将此函数应用于给定的参数。

 */
public class FunctionDemo {
    public static void main(String[] args) {
        //把String类型转int类型
        method("100", s -> Integer.parseInt(s) + 100);
        //把int类型转String类型
        method(100, s -> String.valueOf(s) + 100);
        //把String类型转int类型做操作后再换为String类型
        method("100", s -> Integer.parseInt(s) + 100, s -> String.valueOf(s) + 100);

    }

    //把String类型转int类型
    private static void method(String s, Function<String, Integer> f) {
        int i = f.apply(s);
        System.out.println(i);
    }

    //把int类型转String类型
    private static void method(int i, Function<Integer, String> f) {
        String str = f.apply(i);
        System.out.println(str);
    }

    //把String类型转int类型做操作后再换为String类型
    private static void method(String s, Function<String, Integer> f1, Function<Integer, String> f2) {
        /*int i = f1.apply(s);
        String str = f2.apply(i);
        System.out.println(str);*/
        //方法二
        f1.andThen(f2).apply(s);
    }


}
