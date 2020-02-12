package Day14.demo;

import java.util.function.Supplier;

/*
T get​() 获得结果。
 */
public class SupplierDemo {
    public static void main(String[] args) {
        /*Integer i = getInteger(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        });
        System.out.println(i);*/

        Integer i =getInteger(()->{
            return 1;
        });
        System.out.println(i);
    }

    private static Integer getInteger(Supplier<Integer> s) {
        Integer i = s.get();
        return i;
    }
}
