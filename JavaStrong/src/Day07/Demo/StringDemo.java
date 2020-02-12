package Day07.Demo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
录入一个字符串，判断在每个字符出现的次数，a(5)b(3)c(4)
 */
public class StringDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("强输入字符串：");
        String str = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int a = map.get(str.charAt(i));
                map.put(str.charAt(i), ++a);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        Set<Character> c = map.keySet();
        for (Character key : c) {
            System.out.print(key + "(" + map.get(key) + ")");
        }
    }
}
