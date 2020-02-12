package Day15.relearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> c1 = Class.forName("Day15.Student");
        //Constructor<?>[] cons = c1.getConstructors();
        Constructor<?>[] dcons = c1.getDeclaredConstructors();
        /*for (Constructor s : dcons){
            System.out.println(s);
        }*/
        Constructor<?> cons = c1.getDeclaredConstructor();
        Object o = cons.newInstance();
        Field[] de = c1.getDeclaredFields();
        /*for(Field a : de){
            System.out.println(a);
        }*/

        Field f = c1.getDeclaredField("age");
        f.setAccessible(true);
        f.set(o, 18);
        Method m = c1.getDeclaredMethod("getAge");
        m.setAccessible(true);
        Object invoke = m.invoke(o);
        System.out.println(invoke);

        /*for(Method m2 : m1){
            System.out.println(m2);
        }*/
        //private java.lang.String Day15.Student.method05(java.lang.String,int)
        Method m2 = c1.getDeclaredMethod("method05", String.class, int.class);
        m2.setAccessible(true);
        Object obj = m2.invoke(o, "啦啦啦", 18);
        System.out.println(obj);


    }
}
