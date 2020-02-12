package Day03.neibulei;

public class JumppingDemo {
    public static void main(String[] args) {
        JumppingOperator jo = new JumppingOperator();
        JumppingImpl a = new JumppingImpl();
        jo.method(a);
        System.out.println("_____________________");
        jo.method(new Jumpping() {
            @Override
            public void jump() {
                System.out.println("狗可以跳高了");
            }
        });
    }
}
