package Day06.scorearrays;

import java.util.TreeSet;

public class Student_ZiRanArrays {
    public static void main(String[] args) {

        Student s1 = new Student("张三", 88, 89);
        Student s2 = new Student("b", 98, 89);
        Student s3 = new Student("a", 89, 98);
        Student s4 = new Student("c", 88, 99);
        Student s5 = new Student("赵七", 58, 49);

        TreeSet<Student> set = new TreeSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        for (Student s : set) {
            System.out.println(s.getName() + "语文成绩:" + s.getChinesescore() + "数学成绩:" + s.getMathscore());
        }
    }
}
