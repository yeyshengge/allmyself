package Day15.demo;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo06 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Student> c = Student.class;

        Method[] f = c.getDeclaredMethods();
        //private java.lang.String Day15.Student.method05(java.lang.String,int)
        /*for(Method f1 :f){
            System.out.println(f1);
        }*/

        Method m1 = c.getDeclaredMethod("method05", String.class, int.class);

        Constructor<Student> cons = c.getConstructor();
        Student s1 = cons.newInstance();
        //不管是不是publi，暴力一下
        m1.setAccessible(true);
        Object ss = m1.invoke(s1, "啦啦啦", 18);
        System.out.println(ss);

    }
}
