package Day15.work.subject03;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
第三题：面试题
	1.创建一个ArrayList集合对象名为 list,泛型为Integer类型,随机生成10个整数添加到集合
	将集合的元素进行排序，且遍历出每一个元素
	2.请问，有办法向对象名为 list的集合 中添加String类型的对象？
		若不能，请说明原因
		否则，请代码实现
 */
public class Subject03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int a = r.nextInt(100) + 1;
            list.add(a);
        }
        Collections.sort(list);

        System.out.println(list);

        Class<? extends ArrayList> c = list.getClass();
        Constructor<? extends ArrayList> cons = c.getConstructor();
        //ArrayList l = cons.newInstance();

        Method m = c.getMethod("add", Object.class);

        m.invoke(list, "大");

        System.out.println(list);

    }
}
