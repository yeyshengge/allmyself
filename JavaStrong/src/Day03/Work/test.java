package Day03.Work;

public class test {
    public static void main(String[] args) {
        new Play(){
            @Override
            public void playGame() {
                System.out.println("玩游戏");
            }
        }.playGame();

        //或者
        Play a=new Play(){
            @Override
            public void playGame() {
                System.out.println("玩游戏");
            }
        };
        a.playGame();
    }
}
