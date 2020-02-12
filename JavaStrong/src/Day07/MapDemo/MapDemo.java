package Day07.MapDemo;

/*
remove() 根据键移除键值对元素，返回被删除的键对应的值
booleam containKey 判断是否包含键
booleam containValue 判断是否包含value
isEmpty()判断是否为空
clear();删除全部元素
size()返回集合的键值对个数
get(key):根据键获取值
 */

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "迪丽热巴");
        map.put(2, "古力娜扎");
        map.put(3, "泷泽萝拉");
        map.put(3, "古力娜扎");
        map.put(4, "古力娜扎");


        //remove() 根据键移除键值对元素，返回被删除的键对应的值
        String s = map.remove(3);
        System.out.println(s);

        //clear();删除全部元素
        //map.clear();

        //booleam containKey 判断是否包含键
        System.out.println(map.containsKey(2));

        //booleam containValue 判断是否包含value
        System.out.println(map.containsValue("古力娜扎"));
        System.out.println(map);

        //isEmpty()判断是否为空
        System.out.println(map.isEmpty());

        //size()返回集合的键值对个数
        System.out.println(map.size());


    }
}
