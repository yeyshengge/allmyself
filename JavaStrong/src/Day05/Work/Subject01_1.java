package Day05.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
1.分析以下需求，并用代码实现：
	(1)生成10个1至100之间的随机整数(不能重复)，存入一个List集合(可以先不使用泛型，泛型明天讲)
	用contains方法可以快速做出
 */
public class Subject01_1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        int index = 0;
        while (true) {
            int a = r.nextInt(10) + 1;
            if (!list.contains(a)) {
                list.add(a);
                index++;
            }
            if (index == 10) {
                break;
            }
        }
        System.out.println(list);
    }
}
