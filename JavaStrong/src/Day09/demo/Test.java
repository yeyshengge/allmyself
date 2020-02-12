package Day09.demo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

/*
Arrays.toString(数组)会直接返回该数组的字符串表示...
汉字：UTF—8一个汉字的编码占三个字节
     GBK一个汉字的编码占两个字节
     且第一个字节都是负数
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "abc";
        byte[] b = s.getBytes();
        System.out.println(Arrays.toString(b));//[97, 98, 99]

        String s1 = "中国";
        byte[] b2 = s1.getBytes();
        System.out.println(Arrays.toString(b2));//[-28, -72, -83, -27, -101, -67]

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(a));//[1, 2, 3, 4, 5, 6, 7, 8, 9]

        String s2 = "中国";
        byte[] b3 = s2.getBytes("GBK");//[-42, -48, -71, -6]
        System.out.println(Arrays.toString(b3));



    }
}
