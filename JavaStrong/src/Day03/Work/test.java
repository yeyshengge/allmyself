package Day03.Work;

public class test {
    public static void main(String[] args) {
        new Play(){
            @Override
            public void playGame() {
                System.out.println("����Ϸ");
            }
        }.playGame();

        //����
        Play a=new Play(){
            @Override
            public void playGame() {
                System.out.println("����Ϸ");
            }
        };
        a.playGame();
    }
}
