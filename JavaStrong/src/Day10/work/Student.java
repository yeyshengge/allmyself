package Day10.work;

import java.io.Serializable;

/*
第二题：分析以下需求，并用代码实现
	1.定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性,
	生成空参有参构造,set和get方法,toString方法
	2.创建4个学生对象,将4个学生对象存入到ArrayList集合中
	3.将存有4个学生对象的ArrayList集合对象写入到D:\\StudentInfo.txt文件中
	4.读取D:\\StudentInfo.txt文件中的ArrayList对象并遍历打印
	5.要求使用序列化流来实现
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 2189L;
    private String name;
    private String gender;
    private int age;

    public Student() {
    }

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
