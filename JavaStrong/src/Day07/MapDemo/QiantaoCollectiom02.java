package Day07.MapDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//HashMap存储ArrayList集合
public class QiantaoCollectiom02 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("迪丽热巴");
        list1.add("古力娜扎");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("黄蓉");
        list2.add("郭靖");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("小龙女");
        list3.add("杨过");


        map.put("001", list1);
        map.put("002", list2);
        map.put("003", list3);

        System.out.println(map);

        Set<Map.Entry<String, ArrayList<String>>> en = map.entrySet();
        for (Map.Entry<String, ArrayList<String>> s : en) {
            ArrayList<String> v = s.getValue();
            System.out.println(s.getKey());
            for (String ss : v) {
                System.out.println(ss);
            }
        }


    }
}
