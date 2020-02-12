package com.zps;

import org.junit.Test;

/**
 * Created by zps on 2019/12/16 14:55
 */
public class MyStringBuilder {

    @Test
    public void test() {
        /**
         * 无参构造，一次append长度小于16时：
         * 当长度大于16时，会扩容到16 * 2 + 2 = 34
         * 一次类推  34 * 2 + 2 = 70
         */
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity() + "---" + sb.length());
        sb.append("0");
        System.out.println(sb.capacity() + "---" + sb.length());
        sb.append("000000000000000");
        System.out.println(sb.capacity() + "---" + sb.length());
        sb.append("00");
        System.out.println(sb.capacity() + "---" + sb.length());
        sb.append("0000000000000000");
        System.out.println(sb.capacity() + "---" + sb.length());
        sb.append("0");
        System.out.println(sb.capacity() + "---" + sb.length());
    }

    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.capacity()+"---"+sb.length());
        sb.append("00000000000000000000000000000000000000000000");  //42个
        System.out.println(sb.capacity()+"---"+sb.length());
        sb.append("000");
        System.out.println(sb.capacity()+"---"+sb.length());
    }
}
