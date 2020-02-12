package com.zps.extend;

public class Zi2 extends Fu1 {
    int  num = 30;
    public void showNum(){
        int num= 20;
        System.out.println(num);
        System.out.println(this.num);
    }
public  void methodA(){
    System.out.println("AAA");
}
public  void  methodB(){
        this.methodA();
    System.out.println("BBB");
}
}
