package Day05.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDemo {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        Student s1 = new Student("迪丽热巴", 18);
        Student s2 = new Student("古力娜扎", 17);
        Student s3 = new Student("马尔扎哈", 19);


        list.add(s1);
        list.add(s2);
        list.add(s3);

        System.out.println("=====迭代器");
        Iterator<Student> i = list.iterator();
        while (i.hasNext()) {
            Student next = i.next();
            System.out.println(next.getName() + next.getAge());
        }

        System.out.println("======for循环");
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j).getName() + (list.get(j)).getAge());
        }

        System.out.println("======增强for循环");
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k).getName() + list.get(k).getAge());
        }

    }
}
