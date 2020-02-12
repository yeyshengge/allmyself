package Day06.set;

import java.util.LinkedHashSet;

/*LinkedHashSet集合的特点：
哈希表和链表实现的Set接口，具有可预测的迭代次序
有链表保证元素有序，存储跟取出的元素顺序一样
哈希表保证元素唯一，没有重复元素
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("迪丽热巴");
        lhs.add("古力娜扎");
        lhs.add("马尔扎哈");
        lhs.add("迪丽热巴");//hash保证元素的唯一性

        for (String s : lhs) {
            System.out.println(s);
        }
        int sss = "ssss".compareTo("sss");
        System.out.println(sss);
    }
}
