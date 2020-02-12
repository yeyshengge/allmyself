package Day15.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*
定义一个ArrayList<Integer>集合，往里面加String类型的数据
 */
public class demo07 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);

        Class<? extends ArrayList> c = list.getClass();

        Method add = c.getMethod("add", Object.class);

        add.invoke(list, "啦啦啦");

        System.out.println(list);

    }
}
