package Day01;

public class TeacherStudentDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setAge(30);
        t1.setName("�����Ȱ�");
        System.out.println(t1.getName() + t1.getAge());
        t1.teach();

        Teacher t2 = new Teacher("��������", 18);
        System.out.println(t2.getName() + t2.getAge());


        Student st1 = new Student();
        st1.setName("�������");
        st1.setAge(88);
        System.out.println(st1.getName()+st1.getAge());

        Student st2 = new Student("��������",18);
        System.out.println(st2.getName()+st2.getAge());
    }
}
