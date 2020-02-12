package Day15.relearn;

import Day15.Student;

/*
获取class对象的三个方法
 */
public class GetClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过该类名获取
        Class<Student> c1 = Student.class;
        System.out.println(c1);
        //通过该类对象获取
        Student s = new Student();
        Class<? extends Student> c2 = s.getClass();
        System.out.println(c2);
        //通过全路径，带包名来获取
        Class<?> c3 = Class.forName("Day15.Student");
        System.out.println(c3);
        System.out.println(c1==c2&&c2==c3);
    }
}
