package com.zps.FanXing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*斗地主案例骚扰你的第442骚扰你的第459骚扰你的第465466
 * 1，准备牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 * */
public class DouDiZhu {
    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();
        String[] colors = {"红桃", "梅花", "黑桃", "方块"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
//先把大王，小王存储的poker集合中
        poker.add("大王");
        poker.add("小王");
        //增强FOR循环
        for (String number : numbers) {
            for (String color : colors) {
                //System.out.println(color+number);
                poker.add(color + number);
            }

        }
        //System.out.println(poker);
        //洗牌。 使用集合中的工具类
        Collections.shuffle(poker);//随机组合
        // System.out.println(poker);


        //发牌.定义四个集合
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            String s = poker.get(i);
            //System.out.println(s);
            if (i >= 51) {
                dipai.add(s);
            } else if (i % 3 == 0) {
                player1.add(s);
            } else if (i % 3 == 1) {
                player2.add(s);
            } else {
                player3.add(s);
            }
        }
        System.out.println("玩家1的牌：" + player1);
        System.out.println("玩家2的牌：" + player2);
        System.out.println("玩家3的牌：" + player3);
        System.out.println("底牌" + dipai);
    }

}
