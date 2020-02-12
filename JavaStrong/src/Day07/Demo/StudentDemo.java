package Day07.Demo;

/*
年龄从小到大排序，相同时按姓名字母排序

 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentDemo {
    public static void main(String[] args) {
        ArrayList<Student> list  =new ArrayList<>();

        Student s1 = new Student("linqingxia", 30);
        Student s2 = new Student("zhangmanyu", 35);
        Student s3 = new Student("wangzuxian", 33);
        Student s4 = new Student("liuyan", 33);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student t1, Student t2) {
                int num =t1.getAge()-t2.getAge();
                int num2= num==0?t1.getName().compareTo(t2.getName()):num;
                return num2;
            }
        });

        for (Student s :list){
            System.out.println(s.getName()+"," +s.getAge());
        }


    }
}
