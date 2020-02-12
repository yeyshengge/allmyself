package Day05.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
get(int index)，返回指定索引处的元素
set(int index,E element)设置index处的元素为element，返回被修改处的元素
remove(int index)返回被删除的指定元素
 */
public class ListDemo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("哪儿扎哈");
        list.add("迪丽热巴");

        //remove(int index)返回被删除的指定元素
        String remove = list.remove(2);
        System.out.println(remove);
        System.out.println(list);

        //set(int index,E element)设置index处的元素为element，返回被修改处的元素
        String s = list.set(2, "泷泽萝拉");
        System.out.println(s);
        System.out.println(list);

        //get(int index)，返回指定索引处的元素，所以这方法也可以遍历集合。
        String s1 = list.get(2);
        System.out.println(s1);

        System.out.println("------for循环遍历--------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-----迭代器遍历--------");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }
        System.out.println("-------增强for循环遍历-------");

        for (String str : list) {
            System.out.println(str);
        }

    }


}
