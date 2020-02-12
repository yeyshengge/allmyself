package Day07.Demo;

//统计字符串中各字符出现的次数

import java.util.*;

public class ChencDemo {
    public static void main(String[] args) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = input.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                Integer num = map.get(str.charAt(i));
                num++;
                map.put(str.charAt(i), num);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        Set<Map.Entry<Character, Integer>> en = map.entrySet();
        for (Map.Entry<Character, Integer> s : en) {
            System.out.println(s.getKey() + "出现了" + s.getValue() + "次");
        }
    }
}
