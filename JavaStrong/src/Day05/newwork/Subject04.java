
package Day05.newwork;

import java.util.ArrayList;
import java.util.Iterator;


/*
4. 分析以下需求，并用代码实现
	1.定义Student类
		属性:
			姓名：String name
			年龄：int age
			成绩：int score
		行为:
			空参构造方法
			有参构造方法
			set和get方法
	2.定义测试类,进行测试
		(1)创建5个学生对象存入ArrayList集合中
		(2)打印最高分的学员姓名、年龄、成绩  [要求封装1个方法  参数是集合对象   返回值类型为Student]
		(3)打印5个学生的总成绩和平均分		 [要求封装两个方法完成]
		(4)打印不及格的学员信息及数量		 [要求封装一个方法完成]

 */

public class Subject04 {
    public static void main(String[] args) {
        ArrayList<Subject04Student> list = new ArrayList<>();
        Subject04Student s1 = new Subject04Student("迪丽热巴", 18, 91);
        Subject04Student s2 = new Subject04Student("古力娜扎", 19, 39);
        Subject04Student s3 = new Subject04Student("马尔扎哈", 48, 20);
        Subject04Student s4 = new Subject04Student("泷泽萝拉", 18, 91);
        Subject04Student s5 = new Subject04Student("马云", 58, 19);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);


        Subject04 sub = new Subject04();

        Subject04Student max = sub.max(list);
        System.out.println(max);

        int sum = sub.getSum(list);
        System.out.println("总分:" + sum);

        int avg = sub.average(list);
        System.out.println("平均分" + avg);

        sub.losr(list);

    }

    //只能有一个最高分，如果有多个，只打印第一个。
    private Subject04Student max(ArrayList<Subject04Student> list) {
        int max = list.get(0).getAge();
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i).getScore()) {
                max = list.get(i).getScore();
            }
        }
        // System.out.println(max);
        for (int i = 0; i < list.size(); i++) {

            if (max == list.get(i).getScore()) {
                //Subject04Student s4 = new Subject04Student("adad", 22, 55);
                return list.get(i);
            }
        }
        Subject04Student s = new Subject04Student();
        return s;
    }

    //(3)打印5个学生的总成绩		 [要求封装两个方法完成]
    private int getSum(ArrayList<Subject04Student> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getScore();
        }
        return sum;
    }

    private int average(ArrayList<Subject04Student> list) {
        int avg = 0;
        for (int i = 0; i < list.size(); i++) {
            avg += list.get(i).getScore();
        }
        return avg / (list.size());
    }

    //(4)打印不及格的学员信息及数量		 [要求封装一个方法完成]
    private void losr(ArrayList<Subject04Student> list) {
        //  System.out.println(list);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getScore()) < 60) {
                System.out.println(list.get(i).getName() + list.get(i).getAge() + "岁" + list.get(i).getScore() + "分");
                index++;
            }
        }
        System.out.println("不及格人数：" + index);
    }
}

