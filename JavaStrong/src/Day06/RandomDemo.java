package Day06;

import java.util.HashSet;
import java.util.Random;

/*
存储不重复的随机数，本题用HashSet实现，如果用TreeSet，还会给你排序。
 */
public class RandomDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        Random r = new Random();
        while (set.size() < 10) {
            int a = r.nextInt(20);
            set.add(a);
        }
        for (Integer s : set) {
            System.out.println(s);
        }

    }
}
