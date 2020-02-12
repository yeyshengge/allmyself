package Day13.lambda;

public class AddableDemo {
    public static void main(String[] args) {
        //内部类方式
        useAddable(new Addable() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        });
        //lambda表达式
        useAddable((int a, int b) -> {
            return a + b;
        });

    }

    public static void useAddable(Addable a) {
        int add = a.add(5, 6);
        System.out.println(add);
    }
}
