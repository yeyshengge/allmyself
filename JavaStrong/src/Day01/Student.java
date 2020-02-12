package Day01;

public class Student extends Hunan{
    Student(){}

    Student(String name,int age){
        super(name,age);
    }


    public void study() {
        System.out.println("学习");
    }
}
