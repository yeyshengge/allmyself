package Day07.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*

4. 定义一个泛型为String类型的List集合，统计该集合中每个字符（注意，不是字符串）出现的次数。
例如：集合中有”abc”、”bcd”两个元素，程序最终输出结果为：“a = 1,b = 2,c = 2,d = 1”。
 */
public class subject04 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("z");
        list.add("abadsdadasd");
        System.out.println(list);

        StringBuilder str = new StringBuilder();
        for (String s : list) {
            str.append(s);
        }
        System.out.println(str);
        String s = str.toString();

        HashMap<Character, Integer> map = new HashMap<>();
        int index =0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer a = map.get(s.charAt(i));
                a++;
                map.put(s.charAt(i), a);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        Set<Character> set = map.keySet();
        for (Character c : set) {
           index++;
        }
        System.out.print("“");
        int x =0;
        for (Character c : set) {
          if(x++==index-1) {
              System.out.print(c + "=" + map.get(c));
          }else {
              System.out.print(c + "=" + map.get(c) + ",");
          }
        }
        System.out.println("“");

    }
}
