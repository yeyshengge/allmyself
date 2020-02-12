package Day15.relearn;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Cons {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> c = Student.class;
        Constructor<?>[] cons = c.getDeclaredConstructors();
        //private Day15.Student(java.lang.String,int)
        Constructor<Student> de = c.getDeclaredConstructor(String.class, int.class);
        de.setAccessible(true);
        Student o = de.newInstance("张曼玉", 18);
        System.out.println(o);
       /* for (Constructor<?> con : cons) {
            System.out.println(con);
        }
*/
    }
}
