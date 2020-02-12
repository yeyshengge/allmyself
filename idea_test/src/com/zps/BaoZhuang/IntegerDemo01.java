package com.zps.BaoZhuang;

import java.lang.reflect.Array;
import java.util.ArrayList;

//自动装箱跟自动拆箱
public class IntegerDemo01 {
    public static void main(String[] args) {
        Integer in = 1;//直接把int类型赋值给包装类；相当于Integer in = new Interger(1);

        //自动拆箱
        in = in + 2;//in是包装类，可以自动转为基本数据类型；in+2相当于in.intValue()+2
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);//隐含自动装箱
        int a = list.get(0);//获取第一个数，自动拆箱用int接受


    }


}
