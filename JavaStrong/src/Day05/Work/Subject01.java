package Day05.Work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/*
1.分析以下需求，并用代码实现：
	(1)生成10个1至100之间的随机整数(不能重复)，存入一个List集合(可以先不使用泛型，泛型明天讲)
	(2)编写方法对List集合进行排序,禁用Collections.sort方法和TreeSet
	(2)然后利用迭代器遍历集合元素并输出
	(3)如：15 18 20 40 46 60 65 70 75 91
 */
public class Subject01 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 10; i++) {
            int a = r.nextInt(101);
            if (i == 0) {
                list.add(a);
                continue;
                //System.out.println(list.get(0));
            }
            for (int j = 0; j < i; j++) {
                if (list.get(j) != a) {
                    index++;
                }
            }
            if (index == i) {
                list.add(a);
            } else {
                i--;
            }
            index = 0;
        }
        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    int temp1 = list.get(j);
                    list.set(j, temp);
                    list.set(j + 1, temp1);
                }
            }
        }
        System.out.println("冒泡排序：");
        System.out.println(list);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            System.out.println(next);
        }








       /* int[] a = new int[6];
        Random r = new Random();
        int count = 0;//记录有效的随机数个数
        while (count < a.length) {
            boolean flag = true;
            int b = r.nextInt(10);

            for (int i = 0; i < a.length; i++) {

                if (b == a[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                a[count] = b;
                System.out.println(b);
                count++;
            }
        }*/

        /*int[] arr = new int[10];
        Random r = new Random();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {//循环数组长度次数，循环一次存储一个。
            int a = r.nextInt(10) + 1;
            if (i == 0) {//第一个随机元素存储到数组的第一个位置。
                arr[0] = a;
                continue;
            }
            for (int j = 0; j < i; j++) {// j<i,就是判断这次产生的随机数与前面已经存储的一个一个来比较
                if (arr[j] != a) {//如果随机数与第0个...第i-1个元素是否相等，如果不相等，则index加一。
                    index++;
                }
            }
            if (index == i) {//如果Index++跟i相等，则表示与前面几个比较都不相等
                arr[i] = a;//就把随机数a赋值给arr[i];
            } else {
                i--;//否则，i--
            }
            index = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
    }
}
