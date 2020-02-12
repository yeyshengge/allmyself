package com.zps.FanXing;

public class GenericMethodTest {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        gm.method01(2);
        gm.method01(true);
        gm.method01("sdad");
        gm.method02("静态方法，new 对象.方法，，不推荐使用");

        GenericMethod.method02("静态方法直接类名.方法名");

    }

}
