package Day10.work;

import java.io.*;
import java.util.ArrayList;

/*
第二题：分析以下需求，并用代码实现
	1.定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性,
	生成空参有参构造,set和get方法,toString方法
	2.创建4个学生对象,将4个学生对象存入到ArrayList集合中
	3.将存有4个学生对象的ArrayList集合对象写入到E:\ideaspacework\JavaStrong\src\Day10\work\StudentInfo.txt文件中
	4.读取D:\\StudentInfo.txt文件中的ArrayList对象并遍历打印
	5.要求使用序列化流来实现
 */
public class Subject02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Student> list = new ArrayList<>();


        Student s1 = new Student("刘德华", "男", 45);
        Student s2 = new Student("郭富城", "男", 40);
        Student s3 = new Student("古天乐", "男", 46);
        Student s4 = new Student("王祖贤", "女", 18);


        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        System.out.println(list);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\work\\StudentInfo.txt"));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\work\\StudentInfo.txt"));


        oos.writeObject(list);
        oos.close();

        Object o = ois.readObject();
        ArrayList<Student> arr = (ArrayList<Student>) o;
        for (Student s : arr) {
            System.out.println(s.getName() + "," + s.getGender() + "," + s.getAge());
        }
        ois.close();
    }
}
