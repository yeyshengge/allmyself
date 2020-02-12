package Day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


/*
static <T> List<T> asList​(T... a) 返回由指定数组支持的固定大小的列表。
                        支持修改操作，不支持增加删改
static <E> List<E> of​(E... elements) 返回包含任意数量元素的不可变列表。
                        不能做持增加修改删除
static <E> Set<E> of​(E... elements) 返回一个包含任意数量元素的不可变集合。
                        不能做增删操作，没有修改的方法
 */
public class KeBianCanShu2 {
    public static void main(String[] args) {

       /* //static <T> List<T> asList​(T... a) 返回由指定数组支持的固定大小的列表。
        List<String >  list  = Arrays.asList("Hello","World","Java");
        //list.remove("Java");//UnsupportedOperationException抛出以表示不支持请求的操作
        //list.add("hh");//抛出以表示不支持请求的操作。UnsupportedOperationException
        list.set(2,"C++");
        System.out.println(list);*/

        //static <E> List<E> of​(E... elements) 返回包含任意数量元素的不可变列表。

        //List.of() 应该是JDK 9 才有的方法

        //static <E> Set<E> of​(E... elements) 返回一个包含任意数量元素的不可变集合。
        // Set.of()


    }
}
