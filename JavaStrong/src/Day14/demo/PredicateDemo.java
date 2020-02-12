package Day14.demo;

import java.util.function.Predicate;

/*
default Predicate<T> and​(Predicate<? super T> other) 返回一个组合的谓词，表示该谓词与另一个谓词的短路逻辑AND。
default Predicate<T> negate​() 返回表示此谓词的逻辑否定的谓词。
default Predicate<T> or​(Predicate<? super T> other) 返回一个组合的谓词，表示该谓词与另一个谓词的短路逻辑或。
boolean test​(T t) 在给定的参数上评估这个谓词。
 */
public class PredicateDemo {
    public static void main(String[] args) {

        /*boolean b1 = method("hello", (String s) -> {
            return s.length() > 8;
        });
        System.out.println(b1);*/

        boolean b1 = method("helloWord", s -> s.length() > 8);
        System.out.println(b1);


    }

    private static boolean method(String s, Predicate<String> p) {
        //boolean test​(T t) 在给定的参数上评估这个谓词。
        return p.test(s);
        //default Predicate<T> negate​() 返回表示此谓词的逻辑否定的谓词。
        //return p.negate().test(s);
    }
}
