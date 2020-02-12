package Day07.MapDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentDemo01 {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>();

        Student s1 = new Student("马云", 52);
        Student s2 = new Student("马化腾", 42);
        Student s3 = new Student("王健林", 48);
        Student s4 = new Student("王宝强", 35);


        map.put("001", s1);
        map.put("002", s2);
        map.put("003", s3);
        map.put("004", s4);

        System.out.println(map);


        Set<Map.Entry<String, Student>> en = map.entrySet();

        for (Map.Entry<String, Student> s : en) {
            System.out.println(s.getKey() + "号" + s.getValue().getName() + s.getValue().getAge() + "岁");
        }

        System.out.println("--------------------------");


        Set<String> ss = map.keySet();
        for (String s : ss) {
            System.out.println(s + map.get(s).getName() + map.get(s).getAge());
        }
    }
}
