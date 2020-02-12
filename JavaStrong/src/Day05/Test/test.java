package Day05.Test;

import java.util.*;

public class test {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        int[] arr = new int[6];
        for (int i = 0; i < 100; i++) {
            int a = r.nextInt(20) + 10;
            //System.out.println("=====" + a);
            set.add(a);
        }
        /*Collections.shuffle();
        Collections.*/
        //System.out.println(set + "------");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
           // System.out.println("-----" + next);

        }
        Object[] objects = set.toArray();

        for (int i = 0; i < arr.length; i++) {
            list.add((int) objects[i]);
            // arr[i]=(int)objects[i];
            // System.out.println(arr[i]);
        }
        Collections.shuffle(list);
       // System.out.println(list+"dadad");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
            System.out.println(arr[i]);
        }
    }
}
