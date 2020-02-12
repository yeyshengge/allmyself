package Day07.MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentDemo02 {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();

        Student s1 = new Student("马云", 52);
        Student s2 = new Student("马化腾", 42);
        Student s3 = new Student("王健林", 48);
        Student s4 = new Student("王宝强", 35);
        // Student s5 = new Student("王宝强", 35);

        map.put(s1, "湖南娄底");
        map.put(s2, "湖南新化");
        map.put(s3, "湖南长沙");
        map.put(s4, "湖南一隅");
        //map.put(s5,"sdad");

        System.out.println(map);

        Set<Map.Entry<Student, String>> en = map.entrySet();
        for (Map.Entry<Student, String> ss : en) {
            System.out.println(ss.getKey().getName() + ss.getKey().getAge() + ss.getValue());
        }


    }
}
