package Day06.set;

import java.util.TreeSet;

public class CompareDemo {
    public static void main(String[] args) {

        TreeSet<Student> tr = new TreeSet<>();

        Student s1 = new Student("dilireba", 18);
        Student s2 = new Student("gulinazha", 19);
        Student s3 = new Student("gulinazha", 29);
        Student s4 = new Student("longzeluola", 19);
        Student s5 = new Student("dadadad", 39);

        tr.add(s1);
        tr.add(s2);
        tr.add(s3);
        tr.add(s4);
        tr.add(s5);


        for (Student s : tr) {
            System.out.println(s.getName() + s.getAge());
        }

    }
}
