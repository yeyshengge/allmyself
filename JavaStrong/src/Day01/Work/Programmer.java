package Day01.Work;

public class Programmer extends Worker{
    public Programmer() {
    }

    public Programmer(String name, int id, int salary) {
        super(name, id, salary);
    }

    @Override
    public void work(){
        System.out.println("程序员工作");
    }



}
