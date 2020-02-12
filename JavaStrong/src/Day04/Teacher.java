package Day04;

public class Teacher {

    public void method(int sco) throws ScoreException {
        if (sco < 0 || sco > 100) {
            throw new ScoreException();

        } else {
            System.out.println("分数正常");
        }


    }
}
