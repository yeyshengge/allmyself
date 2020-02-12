package com.zps.Map;
/*
控制台输入一串字符串，判断每个字符出现了多少次;

 */

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class MapTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input:");
        String s = input.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();//定义数组，用来存储
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {//如果重复
                Integer i = map.get(c);
                i++;
                map.put(c, i);
            } else {//不存在重复的
                map.put(c, 1);
            }
        }
        for (Character str : map.keySet()) {//遍历出来
            Integer i = map.get(str);
            System.out.println(str + "出现了" + i + "次");
        }


    }

}
