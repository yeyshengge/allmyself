package Day13.demo.yinyong;

public class StudentDemo {
    public static void main(String[] args) {

        useStudentBuild(Student::new);
    }
    private static void useStudentBuild(StudentBuild s){
        Student a = s.build("张三丰", 18);
        System.out.println(a.getName()+","+a.getAge());
    }
}
