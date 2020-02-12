package Day13.demo.privatedemo;

public class MyInterDemo {
    public static void main(String[] args) {
        MyInter m = new MyInterImpl();
        m.show01();
        m.show02();
        MyInter.method01();
        MyInter.method02();
    }

}
