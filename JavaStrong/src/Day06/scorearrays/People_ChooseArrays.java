package Day06.scorearrays;

import java.util.Comparator;
import java.util.TreeSet;

public class People_ChooseArrays {
    public static void main(String[] args) {
        TreeSet<People> set = new TreeSet<>(new Comparator<People>() {

            @Override
            public int compare(People t1, People t2) {
                int num = (t2.getChinesescore() + t2.getMathscore()) - (t1.getChinesescore() + t1.getMathscore());
                int num2 = num == 0 ? t1.getName().compareTo(t2.getName()) : num;
                return num2;
            }
        });

        People s1 = new People("张三", 88, 89);
        People s2 = new People("b", 98, 89);
        People s3 = new People("a", 89, 98);
        People s4 = new People("c", 88, 99);
        People s5 = new People("赵七", 58, 49);

        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        for (People s : set) {
            System.out.println(s.getName() + "语文成绩:" + s.getChinesescore() + "数学成绩:" + s.getMathscore());
        }
    }
}
