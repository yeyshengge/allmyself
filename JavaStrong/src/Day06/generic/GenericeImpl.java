package Day06.generic;

public class GenericeImpl<T> implements GenericeInter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
