package Day06.set;

import java.util.Comparator;
import java.util.TreeSet;

public class PeopleComparableDemo {
    public static void main(String[] args) {

        People p1 = new People("dilireba", 18);
        People p2 = new People("dilireba", 19);
        People p3 = new People("gureba", 18);
        People p4 = new People("gulinazha", 18);

        TreeSet<People> ts = new TreeSet<>(new Comparator<People>() {
            @Override
            public int compare(People t1, People t2) {
                int num = t1.getAge() - t2.getAge();
                int num2 = num == 0 ? t1.getName().compareTo(t2.getName()) : num;
                return num2;
            }
        });


        ts.add(p1);
        ts.add(p2);
        ts.add(p3);
        ts.add(p4);

        for (People p : ts) {
            System.out.println(p.getName() + "," + p.getAge());
        }

    }
}
