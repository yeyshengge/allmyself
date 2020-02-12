package Day13.lambda;

public class FlyableDemo {
    public static void main(String[] args) {
        //匿名内部类
        useFly(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("灰机");
            }
        });
        System.out.println("--------");

        //lambda表达式
        useFly((String s)->{
            System.out.println(s);
            System.out.println("火箭");
        });



    }
    public static void useFly(Flyable f){
        f.fly("吹啊吹啊吹啊吹");
    }
}
