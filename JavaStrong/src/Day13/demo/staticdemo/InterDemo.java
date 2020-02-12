package Day13.demo.staticdemo;

public class InterDemo {
    public static void main(String[] args) {
        Inter i = new InterImpl();
        i.show();
        i.method();
        Inter.test();


    }
}
