package Day14.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamTest01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("周润发");
        list.add("成龙");
        list.add("刘德华");
        list.add("吴京");
        list.add("周星驰");
        list.add("李连杰");

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("林心如");
        list1.add("张曼玉");
        list1.add("林青霞");
        list1.add("柳岩");
        list1.add("林志玲");
        list1.add("王祖贤");

        //男演员只要名字为三个字的前三人
        Stream<String> man = list.stream().filter(s -> s.length() == 3).limit(3);
        //女演员只要姓林的，且不要第一个
        Stream<String> woman = list1.stream().filter(s->s.startsWith("林")).skip(1);
        //合并前两个
        Stream<String> str = Stream.concat(man, woman);
        //把得到的元素作为构造方法创建演员对象，遍历数据
        str.map(Actor::new).forEach(s-> System.out.println(s.getName()));

        System.out.println("---------");

        Stream.concat(list.stream().filter(s -> s.length() == 3).limit(3), list1.stream().filter(s->s.startsWith("林")).skip(1))
                .map(Actor::new).forEach(s -> System.out.println(s.getName()));

    }
}
