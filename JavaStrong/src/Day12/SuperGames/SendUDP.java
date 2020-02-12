package Day12.SuperGames;

import Day04.DateUtils;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/*
E:\ideaspacework\JavaStrong\src\Day12\SuperGames
 */
public class SendUDP {
    private static Collection<String> player01 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> poker = new ArrayList<>();
        String[] colors = {"♥", "♣", "♠", "♦"};
        String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        poker.add("大王");
        poker.add("小王");
        for (String s : colors) {
            for (String s1 : numbers) {
                poker.add(s + s1);
            }
        }
        Collections.shuffle(poker);

        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        for (int i = 0; i < poker.size(); i++) {
            if (i >= 51 && i < 54) {
                dipai.add(poker.get(i));
            }
            if (i % 3 == 1) {
                player01.add(poker.get(i));
            }
            if (i % 3 == 2) {
                player02.add(poker.get(i));
            }
            if (i % 3 == 0) {
                player03.add(poker.get(i));
            }
        }

        String play = "";
        for (int i = 0; i < player02.size(); i++) {
            if (i == player02.size() - 1) {
                play += player02.get(i);
            } else {
                play += player02.get(i) + ",";
            }
        }
        //创建连接对象
        DatagramSocket ds = new DatagramSocket();
        //标准流输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        byte[] bys2 = play.getBytes();
        InetAddress name2 = InetAddress.getByName("192.168.29.63");
        DatagramPacket dp2 = new DatagramPacket(bys2, bys2.length, name2, 10089);
        ds.send(dp2);
        System.out.println("-------------------------------注意注意-------------------------------");
        System.out.println("游戏规则：打多张牌时请输入以下格式： 花色数字,花色数字,... (例子： ♠K,♥4 无空格),");
        System.out.println("否则该牌无效,游戏中请问说脏话，请遵守游戏规则，本游戏一切解释权归张翩笙所有。");
        System.out.println("你的牌：");
        System.out.println(player01);
        String len;
        while ((len = br.readLine()) != null) {
            if (len.equals("886")) {
                break;
            } else {
                byte[] bys = ("剩"+(player01.size()-2)+"  出  "+len).getBytes();
                InetAddress name = InetAddress.getByName("192.168.29.63");
                DatagramPacket dp = new DatagramPacket(bys, bys.length, name, 10089);
                ds.send(dp);
                BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day12\\SuperGames\\poker.txt"));
                bw.write(len);
                bw.flush();
                BufferedReader br2 = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day12\\SuperGames\\poker.txt"));
                String s = br2.readLine().trim();
                System.out.println("你出的牌是" + s);
                if (s.length() == 0) {
                    System.out.println("请重新输入");
                }
                if (s.length() == 2) {
                    if (player01.contains(s)) {

                        player01.remove(s);
                    }
                }
                if (s.length() > 2) {
                    String[] sp = s.split(",");
                    for (int i = 0; i < sp.length; i++) {
                        //System.out.println(sp[i]);
                        //System.out.println("测试");
                        player01.remove(sp[i]);
                    }
                }
                if (player01.size() == 0) {
                    byte[] bys3 = "你个菜鸡，老子赢了".getBytes();
                    InetAddress name3 = InetAddress.getByName("192.168.29.63");
                    DatagramPacket dp3 = new DatagramPacket(bys3, bys3.length, name3, 10089);
                    ds.send(dp3);
                    System.out.println("恭喜你你赢了");
                }
                //System.out.println("---");
                System.out.println(player01);
            }
        }
        ds.close();
    }
}
