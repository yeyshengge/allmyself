package Day13.lambda;

public class EatableDemo {
    public static void main(String[] args) {
        //实现类
        EatableImpl e = new EatableImpl();
        e.eat();
        //匿名内部类
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("一天一苹果，医生远离我");
            }
        });
        //lambda表达式
        useEatable(()->{
            System.out.println("一天一苹果，医生远离我");
        });

    }

    public static void useEatable(Eatable e) {
        e.eat();
    }
}
