package com.zps.NeiBuLei;

public class OuterTest {

    public static void main(String[] args) {
        outer.Inter obj = new outer().new Inter();
        obj.methodInner();


    }
}
