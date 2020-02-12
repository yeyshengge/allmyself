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
        if (this == o) return true;//�ж��ڴ��ַ�Ƿ�һ����һ��ֱ��true;
        if (o == null || getClass() != o.getClass()) return false;//s2Ϊ�ջ�������ֽ��벻ͬfalse

        Student student = (Student) o;//s2����ת��ΪStudent�����

        if (age != student.age) return false;//�ж������Ƿ�һ��
        return name != null ? name.equals(student.name) : student.name == null;
    }
}
