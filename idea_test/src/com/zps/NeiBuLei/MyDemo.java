package com.zps.NeiBuLei;

public class MyDemo {
    public static void main(String[] args) {
       /* MyInterfaceImpl impl = new MyInterfaceImpl();
        impl.method();*/
    MyInterface impl = new MyInterface() {
        @Override
        public void method() {
            System.out.println("sss");
        }
    };
    impl.method();
    }
}
