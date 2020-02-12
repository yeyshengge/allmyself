package Day15.work.Subject04;
/*
例如在测试类调用该方法：
            Person p = new Person("马峥");
            Object c = getProperty (p, "name");	//恭喜你，这个时候你就 得到 马峥了 ，接下来 你懂的~
        要求：必须使用反射
*/

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Person p = new Person("马峥");
        Student s = new Student("张三",18,"北京");
        Object obj = MyUtils.getProperty(s, "address");
        System.out.println(obj);


    }

}
