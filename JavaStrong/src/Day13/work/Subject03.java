package Day13.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
2.学生信息与成绩如下：
	姓名	数学
	谢霆锋	85  章子怡	63  刘亦菲	77  黄晓明	33  岑小村	92
3.在测试类中完成如下要求
	a)	将五名学生添加到ArrayList集合
	b)	使用Collections.sort(List<T> list, Comparator<? super T> c)方法将学生成绩从小到大进行排序（忽略非空判断）

	i.	使用匿名内部类
	ii.	使用Lambda表达式


 */
public class Subject03 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student("谢霆锋", 85);
        Student s2 = new Student("章子怡", 63);
        Student s3 = new Student("刘亦菲", 77);
        Student s4 = new Student("黄晓明", 33);
        Student s5 = new Student("岑小村", 92);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        System.out.println(list);
        /*
    b)	使用Collections.sort(List<T> list, Comparator<? super T> c)方法将学生成绩从小到大进行排序（忽略非空判断）
	i.	使用匿名内部类
	ii.	使用Lambda表达式
         */

        //i.	使用匿名内部类
        /*Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student t1, Student t2) {
                int num =t1.getScore()-t2.getScore();
                int num2= num== 0?t1.getName().compareTo(t2.getName()):num;
                return num2;
            }
        });*/

        //b)	使用Collections.sort(List<T> list, Comparator<? super T> c)方法将学生成绩从小到大进行排序
        //ii.	使用Lambda表达式

        Collections.sort(list,(t1,t2)->t1.getScore()-t2.getScore()==0?t1.getName().compareTo(t2.getName()):t1.getScore()-t2.getScore());


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName()+","+list.get(i).getScore());
        }

    }
}
