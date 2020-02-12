package Day03.test03;

public class demo {
    public static void main(String[] args) {
       JumpOpt jo = new JumpOpt();
        Jumpping jp = new Cat();
        jo.show(jp);

        Jumpping jj= jo.show01();
        jj.jump();
    }
}
