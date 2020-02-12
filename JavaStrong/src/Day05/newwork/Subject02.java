package Day05.newwork;

import Day01.Work.A;

import java.util.*;

/*
2.分析以下需求，并用代码实现：

	已知集合的元素为
	aaa
	bbb
	ccc
	aaa
	bbb
	bbb
	通过今天所学内容去除集合的重复元素,分别使用迭代器和增强for循环遍历集合
 */
public class Subject02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("ccc");
        list.add("aaa");
        list.add("ccc");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("aaa");
        list.add("cccc");
        list.add("bbb");
        list.add("bbb");
        list.add("ccc");

        Set<Integer> list1 = new HashSet<>();
        int index = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (i != j) {
                    if (list.get(i).equals(list.get(j))) {
                        index++;
                        list1.add(j);
                    }
                }
            }
            index = 0;
        }
        //Collections.sort(list1);
        //System.out.println(list1);
        ArrayList<Integer> arr = new ArrayList<>();
        Iterator<Integer> it = list1.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            arr.add(next);
        }
        //System.out.println(arr);
        System.out.println(list);
        for (int i = arr.size() - 1; i >= 0; i--) {
            //System.out.println(arr.get(i));
            list.remove((int)arr.get(i));
        }
        System.out.println(list);
    }
}
