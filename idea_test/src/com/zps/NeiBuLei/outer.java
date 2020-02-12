package com.zps.NeiBuLei;

public class outer {
    int num = 10;

    public class Inter {
        int num = 20;

        public void methodInner() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(outer.this.num);
        }
    }

}
