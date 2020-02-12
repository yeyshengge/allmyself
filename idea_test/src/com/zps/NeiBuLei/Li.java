package com.zps.NeiBuLei;

public class Li {

    public void method() {
        class Inner {
            int num = 10;

            public void methodInner() {
                System.out.println(num);
            }

        }
        Inner inner = new Inner();
        inner.methodInner();


    }

}
