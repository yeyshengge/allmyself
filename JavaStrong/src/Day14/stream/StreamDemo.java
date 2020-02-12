package Day14.stream;

import java.util.ArrayList;

public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        //System.out.println(list);

        /*ArrayList<String>  threelist = new ArrayList<>();
        for (String s :list){
            if (s.startsWith("张")){
                if(s.length()==3){
                    threelist.add(s);
                }
            }
        }
        System.out.println(threelist);*/

//        list.stream().filter(s -> s.startsWith("张")).filter(s->s.length()==3).forEach(s -> System.out.println(s));

        list.stream().filter(s -> s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);

    }
}
