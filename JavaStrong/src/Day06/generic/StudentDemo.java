package Day06.generic;

public class StudentDemo {
    public static void main(String[] args) {
        Student<String> s = new Student<>();
        s.setT("迪丽热巴");
        System.out.println(s.getT());

        Student<Integer> s2 = new Student<Integer>();
        s2.setT(18);
        System.out.println(s2.getT());

        Student<Boolean> s3 = new Student<Boolean>();
        s3.setT(true);
        System.out.println(s3.getT());
    }
}
