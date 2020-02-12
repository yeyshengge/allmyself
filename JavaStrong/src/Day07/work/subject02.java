package Day07.work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
2. 分析以下需求，并用代码实现：
	(1)统计每个单词出现的次数
	(2)有如下字符串"If you want to change your fate I think you must come to the dark horse to learn java"(用空格间隔)
	(3)打印格式：
		to=3
  		think=1
  		you=2
  		//........
 */
public class subject02 {
    public static void main(String[] args) {
        String str = "If you want to change your fate I think you must come to the dark horse to learn java";
        HashMap<String, Integer> map = new HashMap<>();
        String[] s = str.split(" ");


        for (int i = 0; i < s.length; i++) {
            if (map.containsKey(s[i])) {
                Integer num = map.get(s[i]);
                num++;
                map.put(s[i], num);
            } else {
                map.put(s[i], 1);
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> a : entries) {
            System.out.println(a.getKey() + "=" + a.getValue());
        }
    }
}
