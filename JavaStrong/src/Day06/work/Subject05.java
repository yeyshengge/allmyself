package Day06.work;

import java.util.TreeSet;

/*
5. 十三、分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，
如果成绩一样，那在成绩排序的基础上按照年龄由小到大排序。
姓名（String）	年龄（int）	分数（double）
liusan	          20	90.0
lisi		      22	90.0
wangwu		      20	99.0
sunliu		      22	100.0

 */
public class Subject05 {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        Student s1 = new Student("liusan", 20, 90.0);
        Student s2 = new Student("lisi", 22, 90.0);
        Student s3 = new Student("wangwu", 20, 99.0);
        Student s4 = new Student("sunliu", 22, 100.0);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);


        for (Student s : ts) {
            System.out.println(s.getName() + "," + s.getAge() + "," + s.getScore());
        }


    }
}
