package Day01;

public class TeacherStudentDemo {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setAge(30);
        t1.setName("µÏÀöÈÈ°Í");
        System.out.println(t1.getName() + t1.getAge());
        t1.teach();

        Teacher t2 = new Teacher("¹ÅÁ¦ÄÈÔú", 18);
        System.out.println(t2.getName() + t2.getAge());


        Student st1 = new Student();
        st1.setName("Âí¶ûÔú¹ş");
        st1.setAge(88);
        System.out.println(st1.getName()+st1.getAge());

        Student st2 = new Student("ãñÔóÂÜÀ­",18);
        System.out.println(st2.getName()+st2.getAge());
    }
}
