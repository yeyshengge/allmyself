package Day06.set;

import java.util.HashSet;

public class StudentDemo {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();

        Student s1 = new Student("迪丽热巴", 18);
        Student s2 = new Student("古力娜扎", 18);
        Student s3 = new Student("古力娜扎", 18);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        System.out.println(hs);

        for(Student s : hs){
            System.out.println(s.getName()+s.getAge());
        }
    }
}
