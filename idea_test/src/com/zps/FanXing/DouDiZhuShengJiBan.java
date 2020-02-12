package com.zps.FanXing;
/*
斗地主升级版：有序版
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DouDiZhuShengJiBan {
    public static void main(String[] args) {
        //创建一个Map集合，存储牌的索引和组装好的牌
        HashMap<Integer, String> poker = new HashMap<>();
        //创建一个list集合存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //定义牌的索引
        int index = 0;
        poker.put(index, "大王");
        pokerIndex.add(index);
        index++;
        poker.put(index, "小王");
        pokerIndex.add(index);
        index++;

        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index, color + number);
                pokerIndex.add(index);
                index++;
            }

        }
        //System.out.println(poker);
        //System.out.println(pokerIndex);

//洗牌使用Collentions中的shuffle
        Collections.shuffle(pokerIndex);

        //System.out.println(pokerIndex);
//发牌，定义四个集合


        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer s = pokerIndex.get(i);
            //System.out.println(s);
            if (i >= 51) {
                dipai.add(s);
            } else if (i % 3 == 0) {
                player01.add(s);
            } else if (i % 3 == 1) {
                player02.add(s);
            } else {
                player03.add(s);
            }
        }

        //排序sort默认升序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(dipai);

        show("刘德华", poker, player01);
        show("周润发", poker, player02);
        show("周星驰", poker, player03);
        show("底牌", poker, dipai);
    }

    //看牌方法，提高代码复用性
    public static void show(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        System.out.print(name + "---->");
        for (Integer key : list) {
            String Value = poker.get(key);
            System.out.print(Value + " ");
        }
        System.out.println();
    }


}
