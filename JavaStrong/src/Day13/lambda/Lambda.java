package Day13.lambda;

public class Lambda {
    public static void main(String[] args) {

        //多个参数可以省略参数类型
        useAddable((x,y)->{
            return x+y;
        });
        //一个参数可以省略参数类型跟小括号
        useFly(f->{
            System.out.println(f);
        });
        //只有一条语句的可以省略大括号和分号
        useFly(f->
            System.out.println(f)
        );
        System.out.println("--------");
        //只有一条语句的可以省略大括号和分号，甚至是return
        useAddable((x,y)-> x+y);

    }

    public static void useAddable(Addable a) {
        int add = a.add(5, 5);
        System.out.println(add);
    }

    public static void useFly(Flyable f) {
        f.fly("吹啊吹啊吹啊吹");
    }
}
