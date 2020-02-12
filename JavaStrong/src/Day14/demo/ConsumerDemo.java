package Day14.demo;

import java.util.function.Consumer;

/*
void accept​(T t) 对给定的参数执行此操作。
default Consumer<T> andThen​(Consumer<? super T> after) 返回一个组成的 Consumer ，
依次执行此操作，然后执行 after操作。

 */
public class ConsumerDemo {
    public static void main(String[] args) {
        oprString("迪丽热巴", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        oprString("迪丽热巴",s-> System.out.println(s));

        oprString("迪丽热巴",s -> System.out.println(new StringBuilder(s).reverse().toString()));

        System.out.println("---------");

        oprString("迪丽热巴",s -> System.out.println(s),s ->System.out.println(new StringBuilder(s).reverse().toString()) );

    }
    private static void oprString(String s, Consumer<String> con, Consumer<String> con2) {
//        con.accept(s);
//        con2.accept(s);
        con.andThen(con2).accept(s);
    }
    private static void oprString(String s, Consumer<String> con){
        con.accept(s);

    }
}
