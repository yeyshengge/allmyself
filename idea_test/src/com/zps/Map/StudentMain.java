package com.zps.Map;


import java.util.*;

public class StudentMain {
    public static void main(String[] args) {
        //show01();
        show02();
    }

    public static void show01() {
        HashMap<String, Student> map = new HashMap<>();
        map.put("迪丽热巴", new Student("张一", 19));
        map.put("古力娜扎", new Student("张二", 6));
        map.put("马尔扎哈", new Student("张一", 19));
        map.put("泷泽萝拉", new Student("张一", 18));

        /*Set<Map.Entry<String, Student>> e = map.entrySet();
        Iterator<Map.Entry<String, Student>> it = e.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Student> next = it.next();
            Student value = next.getValue();
            System.out.println(value);
        }*/

        Set<String> key = map.keySet();
        for (String s : key) {
            Student student = map.get(s);
            System.out.println(s + "---" + student);
        }
    }

    public static void show02() {
        HashMap<Student, String> map = new HashMap<>();
        map.put(new Student("古力娜扎", 15), "新疆");
        map.put(new Student("古力娜扎", 15), "中国");
        map.put(new Student("古力娜扎", 16), "中国");
        map.put(new Student("马尔扎哈", 50), "虚空");
        //System.out.println(map);
        Set<Student> students = map.keySet();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student next = it.next();
            String s = map.get(next);
            System.out.println(next + s);
        }
    }
}
