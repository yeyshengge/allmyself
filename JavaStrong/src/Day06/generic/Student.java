package Day06.generic;

/*
泛型类的定义格式
 */
public class Student<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
