package Day04;

public class TeacherDemo {
    public static void main(String[] args) {
        int a = 115;
        Teacher t = new Teacher();
        try {
            t.method(a);
        }catch (ScoreException s){
            s.printStackTrace();
        }
    }
}
