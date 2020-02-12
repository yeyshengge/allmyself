package Day15.demo;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
public void setAccessible​(boolean flag)将此反射对象的accessible标志设置为指示的布尔值。
 值为true表示反射对象应该在使用Java语言访问控制时抑制检查。
 */
public class demo02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<?> c = Student.class;

        //返回所有的构造方法
        Constructor<?>[] c2 = c.getDeclaredConstructors();
        //private Day15.Student(java.lang.String,int)
       /* for (Constructor s :c2){
            System.out.println(s);
        }*/
        //因为这次用private方法，所以用getDeclaredConstructor
        Constructor<?> c3 = c.getDeclaredConstructor(String.class, int.class);

        /*暴力反射，为true
        public void setAccessible​(boolean flag)将此反射对象的accessible标志设置为指示的布尔值。
        值为true表示反射对象应该在使用Java语言访问控制时抑制检查。*/
        c3.setAccessible(true);
        //私有方法赋值
        Object s2 = c3.newInstance("林青霞", 18);

        System.out.println(s2);

    }
}
