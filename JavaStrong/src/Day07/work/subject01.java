package Day07.work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
1.分析以下需求，并用代码实现：
	(1)定义一个学生类Student，包含属性：姓名(String name)、年龄(int age)
	(2)定义Map集合，用Student对象作为key，用字符串(此表示表示学生的住址)作为value
	(3)利用两种方式遍历Map集合中的内容，格式：key:value
 */
public class subject01 {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();

        Student s1 = new Student("迪丽热巴", 18);
        Student s2 = new Student("古力娜扎", 19);
        Student s3 = new Student("泷泽萝拉", 28);
        Student s4 = new Student("马尔扎哈", 58);

        map.put(s1, "北京");
        map.put(s2, "南京");
        map.put(s3, "东京");
        map.put(s4, "西京");

        System.out.println("----遍历方法一----");
        Set<Map.Entry<Student, String>> en = map.entrySet();

        for (Map.Entry<Student, String> s : en) {
            System.out.println(s.getKey().getName() + s.getKey().getAge() + ":" + s.getValue());
        }
        System.out.println("----遍历方法二----");


        Set<Student> ss = map.keySet();
        for (Student s : ss) {
            System.out.println(s.getName() + s.getAge() + ":" + map.get(s));
        }
    }
}
