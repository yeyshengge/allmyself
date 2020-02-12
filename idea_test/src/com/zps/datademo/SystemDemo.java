package com.zps.datademo;

import java.lang.reflect.Array;
import java.util.Arrays;

//静态方法，可以直接调用
public class SystemDemo {
    public static void main(String[] args) {
        /*long l = System.currentTimeMillis();
        for(int i =1;i<9999;i++){
            System.out.println(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);*/
        int[] src ={1,2,3,4,5};
        int[] dest={6,7,8,9,10};

        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(dest));



    }
}
