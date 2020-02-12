package Day05.newwork;

import java.util.ArrayList;
import java.util.Scanner;

/*
3.分析以下需求，并用代码实现：
	键盘录入一个数据,判断是否在集合中存在
	(注意 请分别使用集合的 contains 方法 和自己写代码实现)
 */
public class Subject03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("请输入要查找的值：");
        String str = input.nextLine();
        list.add("迪丽热巴");
        list.add("马尔扎哈");
        list.add("古力娜扎");
        list.add("古力娜扎");


        System.out.println(list.contains(str));
        //自己定义的方法。
        int index = 0;
        for (String s : list) {
            if (str.equals(s)) {
                System.out.println("存在");
                break;
            } else {
                index++;
            }
        }
        if (index == list.size()) {
            System.out.println("不存在");
        }
    }
}
