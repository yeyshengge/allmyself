package Day12.SuperGames;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("111");
        list.add("♠4");
        String s ="111";
        list.remove(s);
        for (String ss :list){
            System.out.println(ss.length());
        }
    }
}
