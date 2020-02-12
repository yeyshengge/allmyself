package Day15.demo;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class demo04 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Student> c = Student.class;

        Constructor<Student> con = c.getConstructor();
        Constructor<?>[] cons = c.getDeclaredConstructors();

        //Day15.Student(java.lang.String,java.lang.String)
        //private Day15.Student(java.lang.String,int)
        //public Day15.Student(java.lang.String,int,java.lang.String)
        //public Day15.Student()


        Field[] de = c.getDeclaredFields();
        //private java.lang.String Day15.Student.name
        //int Day15.Student.age
        //public java.lang.String Day15.Student.address

        /*for (Field a :de){
            System.out.println(a);
        }*/

        Student s = con.newInstance();

        Field name = c.getDeclaredField("name");
        Field age = c.getDeclaredField("age");
        Field address = c.getDeclaredField("address");

        //暴力反射
        name.setAccessible(true);
        age.setAccessible(true);
        address.setAccessible(true);

        //把参数赋值给s的成员变量name/age/address.
        name.set(s, "林志玲");
        age.set(s, 18);
        address.set(s, "日本");

        System.out.println(s);


    }
}
