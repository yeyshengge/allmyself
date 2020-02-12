package Day15.demo;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
structor<T> getDeclaredConstructor​(Class<?>... parameterTypes) 返回一个 Constructor对象，该对象反映由此 Class对象表示的类或接口的指定构造函数。
Constructor<?>[] getDeclaredConstructors​() 返回所Constructor对象的数组。
Constructor<T> getConstructor​(Class<?>... parameterTypes) 返回一个 公开（public）Constructor对象
Constructor<?>[] getConstructors​() 返回一个包含公开（public） Constructor对象的数组
 */
public class demo00 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取一个类的class文件
        Class<Student> c = Student.class;

        //获取公开的构造方法
        Constructor<?>[] c2 = c.getConstructors();
        //public Day15.Student(java.lang.String,int,java.lang.String)
        //public Day15.Student()

        //获取所有的构造方法
        Constructor<?>[] c3 = c.getDeclaredConstructors();
        //Day15.Student(java.lang.String,java.lang.String)
        //private Day15.Student(java.lang.String,int)
        //public Day15.Student(java.lang.String,int,java.lang.String)
        //public Day15.Student()

        //获取无参构造
        Constructor<Student> c4 = c.getConstructor();

        //Constructor类中的T newInstance​(Object... initargs) 使用由此 Constructor对象表示的构造函数，
        // 使用指定的初始化参数来创建和初始化构造函数的声明类的新实例。
        //通过无参构造new实例
        Student s = c4.newInstance();
        System.out.println(s);
       /* for (Student s :c4){
            System.out.println(s);
        }*/
    }
}
