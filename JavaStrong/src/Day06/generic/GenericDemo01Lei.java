package Day06.generic;

/*
泛型方法的定义
           修饰符 <T> void 方法名 (T t){}
 */
public class GenericDemo01Lei {
    public <T> void show(T t) {
        System.out.println(t);
    }
}
