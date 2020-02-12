package day22;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyObjectMapper {
    private static    MyObjectMapper myObjectMapper = new MyObjectMapper();
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {

        User user1 = new User("zhangsan", 19, "男");
        User user2 = new User("lisi", 20, "女");
        People p = new People();
        p.setId(1);
        p.setName("张三");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        p.setList(list);
        myObjectMapper.writeValueString(p);
    }

    public void writeValueString(Object obj) throws IllegalAccessException, ClassNotFoundException {
        Class<?> c = obj.getClass();
        Field[] f = c.getDeclaredFields();

        for (Field field : f) {
            field.setAccessible(true);
            if (field.getName().equals("list")) {
             /*   System.out.println(field.get(obj));
                String str = field.getGenericType().toString();
                String pack = str.substring(str.indexOf("<") + 1, str.indexOf(">"));
                Class<?> cc = Class.forName(pack);
                Field[] ff = cc.getDeclaredFields();*/
                System.out.println(field.getName());

            }
        }
    }

    public static void noList(Object obj) throws IllegalAccessException {
        Class<?> c = obj.getClass();
        Field[] files = c.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < files.length; i++) {
            files[i].setAccessible(true);
            if (i == files.length - 1) {
                sb.append("\"" + files[i].getName() + "\":" + "\"" + files[i].get(obj) + "\"}");
            } else {
                sb.append("\"" + files[i].getName() + "\":" + "\"" + files[i].get(obj) + "\",");
            }

        }
        System.out.println(sb.toString());
    }
}