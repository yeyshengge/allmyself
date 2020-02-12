package Day15.work.Subject04;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//第四题：思考题 工具类中有一个非常屌炸天的方法，可以获取任意类的任意成员变量的值
public class MyUtils {
    public MyUtils() {
    }

    /* 参数： Object obj : 代表可以接收任意类型的对象
             String fieldName ： 代表该对象成员变量的名字
        返回值类型：
            Object : 代表该方法的返回值类型
        也就是说，该方法可以获取任意对象成员变量的值
        例如在测试类调用该方法：
            Person p = new Person("马峥");
            Object c = getProperty (p, "name");	//恭喜你，这个时候你就 得到 马峥了 ，接下来 你懂的~
        要求：必须使用反射 */
    public static Object getProperty(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<?> c = obj.getClass();

        //getProperty(Object obj, String fieldName)

        Field f = c.getDeclaredField(fieldName);
        f.setAccessible(true);

        return f.get(obj);


    }
}
