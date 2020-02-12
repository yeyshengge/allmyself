package Day15;

public class Student {
    private String name;
    int age;
    public String address;

    public Student() {
    }

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(String name, String address) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public void method01(String s) {
        System.out.println("公共" + s);
    }

    void method02() {
        System.out.println("默认");
    }

    private void method03() {
        System.out.println("私有");
    }

    protected void method04() {
        System.out.println("保护");
    }

    private String method05(String s1, int a) {
        return s1 + a;
    }
}
