package Day06.work;



import java.util.HashSet;
import java.util.Scanner;

/*
4.分析以下需求，并用代码实现：
	(1)键盘录入N个数据到 泛型为 Double 的集合,如果录入的是886 停止录入
	(2)对其进行排序
	(3)遍历输出所有元素
	//注意:元素不能重复

 */
public class Subject04 {
    public static void main(String[] args) {
        HashSet<Double> hs = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (i > -1) {
            System.out.println("请输入第" + (i + 1) + "个数 ：");
            double a = input.nextInt();
            if (a == 886) {
                break;
            }
            hs.add(a);
            i++;
        }
        for (Double num : hs) {
            System.out.println(num);
        }

    }
}
