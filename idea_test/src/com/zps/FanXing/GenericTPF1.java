package com.zps.FanXing;

/*泛型的上限（？ extend E）代表使用的泛型只能是E类型的子类或本身
下限(? super E)代表使用的泛型只能是E类型的父类或本身
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericTPF1 {
    public static void main(String[] args) {
        Collection<Integer> list01 = new ArrayList<>();
        Collection<String> list02 = new ArrayList<>();
        Collection<Number> list03 = new ArrayList<>();
        Collection<Object> list04 = new ArrayList<>();


        //Integer extends Number extends Object
        //String extends Object


        method1(list01);
       // method1(list02);//报错
        method1(list03);
       // method1(list04);//报错

       // method2(list01);//报错
       // method2(list02);//报错
        method2(list03);
        method2(list04);

    }

    public static void method1(Collection<? extends Number> list) {}//上限



    public static void method2(Collection<? super Number> list){}//下限

}
