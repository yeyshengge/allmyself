package Day07.DouDiZhu;

import java.util.ArrayList;
import java.util.Collections;

public class DouDiZhu {
    public static void main(String[] args) {

        ArrayList<String> poker= new ArrayList<>();

        String[] colors = {"♥", "♣", "♠", "♦"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        poker.add("大王");
        poker.add("小王");

        for (String s :colors){
            for(String s1 :numbers){
                poker.add(s+s1);
            }
        }
        Collections.shuffle(poker);

        //System.out.println(poker);


        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            if(i>=51&&i<54){
                dipai.add(poker.get(i));
            }
            if(i%3==1){
                player01.add(poker.get(i));
            }
            if(i%3==2){
                player02.add(poker.get(i));
            }
            if(i%3==0){
                player03.add(poker.get(i));
            }
        }
        System.out.println("底牌："+dipai);
        System.out.println("玩家一："+player01);
        System.out.println("玩家二："+player02);
        System.out.println("玩家三："+player03);

    }
}
