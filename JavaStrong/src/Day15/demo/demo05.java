package Day15.demo;

import Day15.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
method  getMethod​(String name, Class<?>... parameterTypes) 返回一个 方法对象，该对象反映由该 Class对象表示的类或接口的指定公共成员方法。
method[]  getMethods​() 返回一个包含 方法对象的数组， 方法对象反映由该 Class对象表示的类或接口的所有公共方法，包括由类或接口声明的对象以及从超类和超级接口继承的类。
method  getDeclaredMethod​(String name, Class<?>... parameterTypes) 返回一个 方法对象
method[]  getDeclaredMethods​() 返回一个包含 方法对象的数组，包括public，protected，default（package）访问和私有方法，但不包括继承方法。
 */
public class demo05 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Student> c = Student.class;

        Constructor<Student> con = c.getConstructor();
        Student s1 = con.newInstance();

        Method[] m1 = c.getMethods();//次方法数组包含该类以及父类中所有的public方法
        Method[] m2 = c.getDeclaredMethods();//该方法数组返回该类中的所有方法

        /*for(Method me :m2){
            System.out.println(me);
        }*/
        //public void Day15.Student.method01(java.lang.String)调用此方法
        //第一个参数为该方法的名字
        Method m3 = c.getMethod("method01", String.class);
        //Object invoke​(Object obj, Object... args) 在具有指定参数的指定对象上调用此 方法对象表示的基础方法。
        //第一个参数是该类的对象，用来调用方法,第二个参数是该方法传递的参数
        m3.invoke(s1, "啦啦啦");


    }
}
