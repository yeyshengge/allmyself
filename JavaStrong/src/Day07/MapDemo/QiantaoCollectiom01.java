package Day07.MapDemo;

/*
ArrayList存储HsahMap数据
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class QiantaoCollectiom01 {
    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();

        map1.put("001", "小云");
        map1.put("002", "大云");

        HashMap<String, String> map2 = new HashMap<>();

        map2.put("003", "郭靖");
        map2.put("004", "黄蓉");

        HashMap<String, String> map3 = new HashMap<>();

        map3.put("005", "杨过");
        map3.put("006", "小龙女");

        list.add(map1);
        list.add(map2);
        list.add(map3);

        System.out.println(list);

        for (HashMap<String, String> s : list) {//s是代表每个hashMap集合
            Set<String> st = s.keySet();
            for (String ss : st) {
                System.out.println(ss + s.get(ss));
            }
        }
    }
}
