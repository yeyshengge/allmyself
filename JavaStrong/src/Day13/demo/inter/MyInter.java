package Day13.demo.inter;

public interface MyInter {
    void show01();

    void show02();

    public default void show03(){
        System.out.println("接口中show03调用");
    }
}
