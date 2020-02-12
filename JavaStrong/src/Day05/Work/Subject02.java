package Day05.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
2.分析以下需求，并用代码实现：
	(1)定义List集合，存入多个字符串
	(2)删除集合中字符串"def"
	(3)然后利用迭代器遍历集合元素并输出
 */
public class Subject02 {
    public static void main(String[] args) {
        List<String> list  =new ArrayList<>();
        list.add("dad");
        list.add("def");
        list.add("h");
        list.add("love");
        list.add("def");
        System.out.println(list);

        String str ="def";

        //ConcurrentModificationException
        /*istIterator lit = list.listIterator();
        while (lit.hasNext()){
            Object next = lit.next();
            if(next.equals(str)){
                list.remove(next);
            }
            System.out.println(next);
        }*/

        for (int i = 0; i < list.size(); i++) {
            String a=list.get(i);
            if(a.equals(str)){
                list.remove( i);
            //   continue;
            }
          //  System.out.println(list.get(i));

        }
        System.out.println(list);

    }
}
