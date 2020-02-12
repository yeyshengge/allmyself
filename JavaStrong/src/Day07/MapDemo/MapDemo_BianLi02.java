package Day07.MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
map.entrySet获取每一对键跟值得组合
然后调用entry中的getKey()跟getValue()
 */
public class MapDemo_BianLi02 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "迪丽热巴");
        map.put(2, "古力娜扎");
        map.put(3, "泷泽萝拉");
        map.put(3, "古力娜扎");
        map.put(4, "古力娜扎");


        Set<Map.Entry<Integer, String>> et = map.entrySet();
        for (Map.Entry<Integer, String> s : et) {
            System.out.println(s.getKey() + "," + s.getValue());

            //System.out.println(s);
        }
    }
}
