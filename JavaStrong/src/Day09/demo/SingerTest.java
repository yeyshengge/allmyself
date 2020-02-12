package Day09.demo;

import java.util.ArrayList;

public class SingerTest {
    public static void main(String[] args) {
        Singer s1 = new Singer("刘德华",25,"打篮球");
        Singer s2 = new Singer("张学友",35,"游泳");
        Singer s3 = new Singer("郭富城",19,"踢足球");
        Singer s4 = new Singer("黎明",18,"击剑");

        ArrayList<Singer> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getAge()>30){
                list.get(i).setLike("打保龄球");
            }
            if(list.get(i).getAge()<20){
                list.remove(i);
                i--;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName()+","+list.get(i).getAge()+","+list.get(i).getLike());
        }
    }
}
