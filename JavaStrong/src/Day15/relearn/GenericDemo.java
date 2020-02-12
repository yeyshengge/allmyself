package Day15.relearn;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
反射越过泛型检查
 */
public class GenericDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(16);
        list.add(11);
        list.add(14);
        list.add(13);

        Class<? extends ArrayList> c = list.getClass();
        //Constructor<? extends ArrayList> cons = c.getConstructor();
        //cons.setAccessible(true);
        //ArrayList obj = cons.newInstance();

        /*Method[] declaredMethods = c.getDeclaredMethods();
        for (Method d :declaredMethods){
            System.out.println(d);
        }
        */
        //public boolean java.util.ArrayList.add(java.lang.Object)

        Method add = c.getDeclaredMethod("add", Object.class);
        add.setAccessible(true);
        add.invoke(list, "我是String");
        add.invoke(list, 5.5);
        System.out.println(list);


    }
}
