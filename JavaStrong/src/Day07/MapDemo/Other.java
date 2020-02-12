package Day07.MapDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Other {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("张飞");
        arr1.add("赵云");
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("唐僧");
        arr2.add("孙悟空");
        ArrayList<String> arr3 = new ArrayList<>();
        arr3.add("鲁智深");
        arr3.add("武松");

        hm.put("三国演义", arr1);
        hm.put("西游记", arr2);
        hm.put("水浒传", arr3);

        System.out.println(hm);
        Set<String> s = hm.keySet();
        for (String key : s) {
            System.out.println(key);
            ArrayList<String> list = hm.get(key);
            for (String l : list) {
                System.out.println("\t" + l);
            }
        }
    }
}
