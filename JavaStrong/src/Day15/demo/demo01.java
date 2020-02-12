package Day15.demo;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class demo01 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> c = Student.class;

        //此方法会输出该类的显示构造方法
        Constructor<?>[] c2 = c.getConstructors();
        //public Day15.Student(java.lang.String,int,java.lang.String)
        //public Day15.Student()

        //括号里写参数类型，记得点class
        Constructor<Student> c3 = c.getConstructor(String.class,int.class,String.class);

        //实例化一个对象，参数与上面匹配
        Student s1= c3.newInstance("林青霞",18,"香港");

        System.out.println(s1);

        /*for(Constructor s :c2){
            System.out.println(s);
        }*/

        //无参构造
        Constructor<Student> c4 = c.getConstructor();
        Student s2 = c4.newInstance();
        s2.setName("王祖贤");
        s2.setAge(19);
        s2.setAddress("香港");
        System.out.println(s2);

    }
}
