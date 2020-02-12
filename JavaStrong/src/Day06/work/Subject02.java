package Day06.work;

import java.util.ArrayList;
import java.util.HashSet;

/*
2.已知ArrayLiST集合的元素为
	aaa
	bbb
	ccc
	aaa
	bbb
	bbb
	要求去除重复元素,通过今天的学习你会怎么做?
 */
public class Subject02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);

        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            hs.add(list.get(i));
        }

        System.out.println("-----遍历一下-----");
        System.out.println(hs);
        for (String s : hs){
            System.out.println(s);
        }


    }
}
