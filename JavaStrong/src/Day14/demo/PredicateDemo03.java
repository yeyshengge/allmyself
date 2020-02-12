package Day14.demo;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
姓名长度大于2，年龄大于33
 */
public class PredicateDemo03 {
    public static void main(String[] args) {
        String[] arr = {"林青霞,30", "柳岩,34", "张曼玉,35", "貂蝉,31", "王祖贤,34"};
        ArrayList<String> array = method(arr, s -> s.split(",")[0].length() > 2, s -> Integer.valueOf(s.split(",")[1]) > 33);
        System.out.println(array);
    }


    private static ArrayList<String> method(String[] ss, Predicate<String> p1, Predicate<String> p2) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : ss) {
            if (p1.and(p2).test(s)) {
                list.add(s);
            }
        }
        return list;
    }
}
