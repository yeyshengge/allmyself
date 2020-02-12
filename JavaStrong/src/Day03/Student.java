package Day03;

public class Student {

    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {//this---s1    o---s2;
        if (this == o) return true;//判断内存地址是否一样，一样直接true;
        if (o == null || getClass() != o.getClass()) return false;//s2为空或者类的字节码不同false

        Student student = (Student) o;//s2向下转型为Student类对象

        if (age != student.age) return false;//判断年龄是否一致
        return name != null ? name.equals(student.name) : student.name == null;
    }
}
