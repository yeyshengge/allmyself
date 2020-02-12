package Day13.demo.staticdemo;

public interface Inter {
    void show();
    default void method(){
        System.out.println("接口中的默认方法被调用");
    }
    static void test(){
        System.out.println("接口中静态方法被调用");
    }
}
