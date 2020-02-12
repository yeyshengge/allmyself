package Day01.Work;

public class Work01Test {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.setId(666);
        m.setName("µÏÀöÈÈ°Í");
        m.setSalary(15000);
        System.out.println(m.getId()+m.getName()+m.getSalary());
    }
}
