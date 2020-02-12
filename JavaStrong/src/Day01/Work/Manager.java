package Day01.Work;

public class Manager extends Worker {
    public Manager() {
    }

    public Manager(String name, int id, int salary) {
        super(name, id, salary);
    }

    @Override
    public void work(){
        System.out.println("经理工作");
    }

}
