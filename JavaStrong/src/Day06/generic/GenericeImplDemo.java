package Day06.generic;

public class GenericeImplDemo {
    public static void main(String[] args) {
        GenericeImpl<String> s1 = new GenericeImpl<>();
        s1.show("羁绊");

        GenericeImpl<Integer> s2 = new GenericeImpl<>();
        s2.show(666);

        GenericeImpl<Boolean> s3 =new GenericeImpl<>();
        s3.show(true);
    }
}
