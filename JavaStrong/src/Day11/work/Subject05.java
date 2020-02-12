package Day11.work;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。

 */
public class Subject05 {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            Student s = new Student();
            System.out.println("输入学生名字：");
            String name = sc.next();
            s.setName(name);
            System.out.println("学生学号：");
            String id = sc.next();
            s.setId(id);
            System.out.println("语文成绩：");
            int chinese = sc.nextInt();
            s.setChinese(chinese);
            System.out.println("数学成绩：");
            int math = sc.nextInt();
            s.setMath(math);
            System.out.println("英语成绩：");
            int english = sc.nextInt();
            s.setEnglish(english);
            list.add(s);
        }
        System.out.println(list);
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\ideaspacework\\JavaStrong\\src\\Day11\\work\\subject"));
        for (int i = 0; i < list.size(); i++) {
            String str = "学号" + list.get(i).getId() + "姓名" + list.get(i).getName() + "语文" + list.get(i).getChinese() + "数学" + list.get(i).getMath() + "英语" + list.get(i).getEnglish() + "平均分" + list.get(i).avg();
            bw.write(str);
            bw.newLine();
            bw.flush();

        }
        bw.close();


    }
}
