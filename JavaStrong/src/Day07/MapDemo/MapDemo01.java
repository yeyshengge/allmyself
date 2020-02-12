package Day07.MapDemo;


import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*
get(key) 根据键获取值；
keySet() 获取所有键的集合返回值为Set集合
values() 获取所有值得集合，返回值为Collection集合
 */
public class MapDemo01 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("001", "迪丽热巴");
        map.put("002", "古力娜扎");
        map.put("003", "泷泽萝拉");
        map.put("004", "马尔扎哈");
        System.out.println(map);

        System.out.println(map.get("002")); //古力娜扎

        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s);
            // System.out.println(map.get(s));也可以返回所有的value
        }

        Collection<String> v = map.values();
        for (String ss : v) {
            System.out.println(ss);
        }
    }
}
