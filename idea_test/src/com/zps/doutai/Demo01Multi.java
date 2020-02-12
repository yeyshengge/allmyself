package com.zps.doutai;
//父类引用指向之类对象
//父类名称(接口名称) 对象名 =  new 子类名称(实现类名)();

public class Demo01Multi {
    public static void main(String[] args) {
        Fu obj = new Zi();
        obj.method();
        obj.meyhodFu();
        System.out.println(obj.num);
        //System.out.println(obj.age);
        obj.show();
    }
}
