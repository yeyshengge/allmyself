package Day14.demo;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        int arr[] = {99, 23, 43, 232, 44, 666};
        /*int s = getMax(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int max = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (max < arr[i]) {
                        max = arr[i];
                    }
                }
                return max;
            }
        });
        System.out.println(s);*/

        int max1 = getMax(() -> {
            int max = 0;
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        });
        System.out.println(max1);
    }

    private static int getMax(Supplier<Integer> sup) {
        Integer i = sup.get();
        return i;
    }
}
