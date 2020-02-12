package Day05.Work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
3.分析以下需求，并用代码实现：
	(1)定义List集合，存入多个字符串
	(2)删除集合中包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
	(3)然后利用迭代器遍历集合元素并输出
 */
public class Subject03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("555");
        list.add("love");
        list.add("l0ve");
        list.add("1ove");
        list.add("10ve");
        list.add("dadasff8bdb");
        list.add("zpspasdadad6");
        list.add("zpspasdadadadasdas sd ");

        List<Integer> length = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            length.add(next.length());
        }
        //System.out.println(length);
        List<String> index = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            for (int j = 0; j < length.get(i); j++) {
               //System.out.println(str.charAt(j));
                if (48 <= str.charAt(j) && str.charAt(j) <= 57) {
                    //list.remove(list.get(i));
                    index.add(str);
                    break;
                }
            }
        }
        // System.out.println(list);
        // System.out.println(index);
        for (int i = 0; i < index.size(); i++) {
            list.remove(index.get(i));
        }
       // System.out.println(list);

        Iterator<String> itt = list.iterator();
        while(itt.hasNext()){
            String next = itt.next();
            System.out.println(next);
        }
    }
}
