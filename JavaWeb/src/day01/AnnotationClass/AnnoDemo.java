package day01.AnnotationClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
该方法用来调取任何类中的方法，只需要在注解中标注相关字段。
 */
@Anno(className = "day01.AnnotationClass.Student", methodName = "show")
public class AnnoDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        //1,获取该类的字节码文件
        Class<AnnoDemo> annoc = AnnoDemo.class;

        //<A extends Annotation> A getAnnotation​(Class<A> annotationClass) 返回该元素的注释
        //获取本类的注解对象
        Anno an = annoc.getAnnotation(Anno.class);

        /* 上面这串代码实际就是定义一个实现类，如下
        public class AnnoImpl implements Anno{
            public String className(){
                return "day01.AnnotationClass.Student";
                }
            public String methodName(){
                return "show";
                }
        }
         */
        //调用注释对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        System.out.println(className);
        System.out.println(methodName);

        Class<?> c = Class.forName(className);
        Constructor<?> cons = c.getConstructor();
        Object obj = cons.newInstance();
        Method m = c.getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(obj);


    }
}
