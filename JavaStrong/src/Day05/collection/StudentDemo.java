package Day05.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentDemo {
    public static void main(String[] args) {
        Collection<Student> coll = new ArrayList<>();
        Student st = new Student("迪丽热巴", 18);
        Student st2 = new Student("古力娜扎", 17);
        Student st3 = new Student("马尔扎哈", 19);
        coll.add(st);
        coll.add(st2);
        coll.add(st3);

        Iterator<Student> it = coll.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            //System.out.println(student);//这样输入的话要重写Student中的toString方法；
            System.out.println(student.getName() + student.getAge());
        }

    }
}
