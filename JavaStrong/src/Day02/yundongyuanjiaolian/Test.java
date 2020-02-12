package Day02.yundongyuanjiaolian;

public class Test {
    public static void main(String[] args) {
        YunDongYuan player = new PingPangartist();
        player.setName("ÁõÏè");
        player.setAge(18);
        System.out.println(player.getName()+player.getAge());
        player.study();
        PingPangartist a =(PingPangartist)player;
        a.speak();


    }
}
