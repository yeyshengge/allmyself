package Day15.demo;


import Day15.Student;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
Field getField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定公共成员字段。
Field[] getFields​() 返回一个包含 Field对象的数组， Field对象反映由该 Class对象表示的类或接口的所有可访问的公共字段。
Field getDeclaredField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定声明字段。
Field[] getDeclaredFields​() 返回一个 Field对象的数组，反映了由该 Class对象表示的类或接口声明的所有字段。
 */
public class demo03 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        //获取class对象
        Class<Student> c = Student.class;

        //获取该类的公开成员变量
        Field[] fields = c.getFields();//public java.lang.String Day15.Student.address

        //获取该类的所有成员变量
        Field[] fields1 = c.getDeclaredFields();//得到以下三个
        //private java.lang.String Day15.Student.name
        //int Day15.Student.age
        //public java.lang.String Day15.Student.address

        //获取成员变量
        Field field = c.getField("address");

        Constructor<Student> cons = c.getConstructor();

        //创建学生类对象s
        Student s = cons.newInstance();

        //给对象s的成员变量field赋值
        field.set(s,"西安");
        System.out.println(s);




       /*for(Field f :fields1){
            System.out.println(f);
        }*/
    }
}
