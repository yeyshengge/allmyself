package Day14.demo;

import java.util.function.Predicate;

/*
default Predicate<T> and​(Predicate<? super T> other) 返回一个组合的谓词，表示该谓词与另一个谓词的短路逻辑AND。
default Predicate<T> or​(Predicate<? super T> other) 返回一个组合的谓词，表示该谓词与另一个谓词的短路逻辑或。
 */
public class PredicateDemo02 {
    public static void main(String[] args) {

        boolean b1 = method("helloworld", s -> s.length() > 13, s -> s.length() < 15);
        System.out.println(b1);

    }

    private static boolean method(String s, Predicate<String> p1, Predicate<String> p2) {
        //return p1.and(p2).test(s);
        return p1.or(p2).test(s);
    }
}
