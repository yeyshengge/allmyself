package Day06.set;


import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(100);
        ts.add(30);
        ts.add(80);
        ts.add(50);
        ts.add(20);
        ts.add(100);//不能存储重复元素

        System.out.println(ts);

    }
}
