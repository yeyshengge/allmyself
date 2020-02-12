package Day15.relearn;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class File {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> c = Student.class;
        Field[] f = c.getDeclaredFields();
        //private java.lang.String Day15.Student.name
        Field name = c.getDeclaredField("name");
        Constructor<Student> de = c.getDeclaredConstructor();
        Student student = de.newInstance();
        name.setAccessible(true);
        name.set(student,"张三");
        System.out.println(student);

       /* for (Field field : f) {
            System.out.println(field);
        }*/
    }
}
