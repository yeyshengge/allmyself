package Day03;

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 =new Student();
        s1.setName("µÏÀöÈÈ°Í");
        s1.setAge(18);
        System.out.println(s1);
        System.out.println(s1.getName()+s1.getAge());


        Student s2  =new Student();
        s2.setName("µÏÀöÈÈ°Í");
        s2.setAge(18);


        System.out.println(s2.getName()+s2.getAge());

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
    }
}
