package Day07.MapDemo;

import java.util.HashMap;
import java.util.Set;

/*
根据keySet集合获取到key的集合
然后根据get方法获取值

 */
public class MapDemo_BianLi01 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("001", "迪丽热巴");
        map.put("002", "古力娜扎");
        map.put("003", "泷泽萝拉");
        map.put("004", "马尔扎哈");

        System.out.println(map);

        //获取key的集合。
        Set<String> set = map.keySet();

        for (String s : set) {
            String v = map.get(s);//根据key获取value
            System.out.println(s + "," + v);
        }


    }
}
