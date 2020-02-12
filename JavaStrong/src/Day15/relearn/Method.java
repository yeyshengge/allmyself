package Day15.relearn;

import Day15.Student;

import java.lang.reflect.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Method {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> c = Student.class;
        Constructor<Student> de = c.getDeclaredConstructor();
        Student s = de.newInstance();
        java.lang.reflect.Method[] dec = c.getDeclaredMethods();
        /*for (java.lang.reflect.Method method : dec) {
            System.out.println(method);
        }*/
        //private java.lang.String Day15.Student.method05(java.lang.String,int)
        java.lang.reflect.Method m = c.getDeclaredMethod("method05", String.class, int.class);
        m.setAccessible(true);
        Object ss = m.invoke(s, "张三", 180);
        System.out.println(ss);
    }
}
