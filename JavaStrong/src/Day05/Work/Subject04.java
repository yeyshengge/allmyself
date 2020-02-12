package Day05.Work;

import Day05.list.Student;

import java.util.ArrayList;
import java.util.Iterator;

/*
4.  定义一个学生类Student，包含三个属性姓名、年龄、性别，创建三个学生对象存入ArrayList集合中。
A：遍历集合遍历输出。
B：求出年龄最大的学生，然后将该对象的姓名变为：小猪佩奇。
 */
public class Subject04 {
    public static void main(String[] args) {

        Subject04Student s1 = new Subject04Student("迪丽热巴", 48, "女");
        Subject04Student s2 = new Subject04Student("古力娜扎", 39, "女");
        Subject04Student s3 = new Subject04Student("马尔扎哈", 28, "男");

        ArrayList<Subject04Student> list = new ArrayList<>();

        list.add(s1);
        list.add(s2);
        list.add(s3);

        Iterator<Subject04Student> it = list.iterator();
        while (it.hasNext()) {
            Subject04Student next = it.next();
            System.out.println(next.getName() + next.getAge() + next.getSex());
        }
        int max = 0;
        int count = -1;//查看比较次数，如果第一个是最大的，就只比较一次，
        for (Subject04Student i : list) {
            if (max < i.getAge()) {
                max = i.getAge();
                count++;
            }

        }

        System.out.println("年龄最大的为：" + max);
        System.out.println(count);

        Subject04Student s4 = new Subject04Student("小猪佩奇", list.get(0).getAge(), list.get(0).getSex());
        list.set(0, s4);
        for (Subject04Student s : list) {
            System.out.println(s.getName() + s.getAge() + s.getSex());
        }


        // for (int i=0;i<list.)
    }
}
