package Day07.DouDiZhu;

//斗地主升级版，进行排序

import java.util.*;

public class DouDiZhuShengJi {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        String[] colors = {"♦", "♣", "♥", "♠"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        ArrayList<Integer> bianhao = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            bianhao.add(i);
        }
        System.out.println(bianhao);

        ArrayList<String> pai = new ArrayList<>();

        for (String s2 : numbers) {
            for (String s : colors) {
                pai.add(s + s2);
            }
        }
        for (int i = 0; i < pai.size(); i++) {
            map.put(bianhao.get(i), pai.get(i));
        }
        map.put(52, "小王");
        map.put(53, "大王");
        System.out.println(map);// 固定牌的顺序{0=♦3, 1=♣3, 2=♥3, 3=♠3, 4=♦4, 5=♣4, 6=♥4, 7=♠4, 8=♦5, 9=♣5, 10=♥5, 11=♠5, 12=♦6, 13=♣6, 14=♥6, 15=♠6, 16=♦7, 17=♣7, 18=♥7, 19=♠7, 20=♦8, 21=♣8, 22=♥8, 23=♠8, 24=♦9, 25=♣9, 26=♥9, 27=♠9, 28=♦10, 29=♣10, 30=♥10, 31=♠10, 32=♦J, 33=♣J, 34=♥J, 35=♠J, 36=♦Q, 37=♣Q, 38=♥Q, 39=♠Q, 40=♦K, 41=♣K, 42=♥K, 43=♠K, 44=♦A, 45=♣A, 46=♥A, 47=♠A, 48=♦2, 49=♣2, 50=♥2, 51=♠2}

        Collections.shuffle(bianhao);

        TreeSet<Integer> player01 = new TreeSet<>();
        TreeSet<Integer> player02 = new TreeSet<>();
        TreeSet<Integer> player03 = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();

        for (int i = 0; i < bianhao.size(); i++) {
            if (i >= 51 && i < 54) {
                dipai.add(bianhao.get(i));
            }
            if (i % 3 == 1) {
                player01.add(bianhao.get(i));
            }
            if (i % 3 == 2) {
                player02.add(bianhao.get(i));
            }
            if (i % 3 == 0) {
                player03.add(bianhao.get(i));
            }
        }
        System.out.println("底牌：" + dipai);
        System.out.println("玩家一：" + player01);
        System.out.println("玩家二：" + player02);
        System.out.println("玩家三：" + player03);

        System.out.println("底牌");
        for (Integer i : dipai) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
        System.out.println("玩家一");
        for (Integer i : player01) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
        System.out.println("玩家二");
        for (Integer i : player02) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
        System.out.println("玩家三");
        for (Integer i : player03) {
            System.out.print(map.get(i) + " ");
        }


    }
}
