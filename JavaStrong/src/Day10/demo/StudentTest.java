package Day10.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class StudentTest {
    public static void main(String[] args) throws IOException {
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student t0, Student t1) {
                int num = (t1.getChinese() + t1.getEnglist() + t1.getMath()) - (t0.getChinese() + t0.getEnglist() + t0.getMath());
                int num1 = num == 0 ? (t1.getChinese() - t0.getChinese()) : num;
                int num2 = num1 == 0 ? (t1.getEnglist() - t0.getEnglist()) : num1;
                int num3 = num2 == 0 ? (t1.getName().compareTo(t0.getName())) : num2;
                return num3;
            }
        });
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("请输入学生姓名");
            String st1 = sc.next();
            System.out.println("请输入语文成绩");
            int st2 = sc.nextInt();
            System.out.println("请输入数学成绩");
            int st3 = sc.nextInt();
            System.out.println("请输入英语成绩");
            int st4 = sc.nextInt();
            Student s1 = new Student(st1, st2, st3, st4);
            ts.add(s1);
        }
        //E:\ideaspacework\JavaStrong\src\Day10\java.txt
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"));
        for (Student s : ts) {
            // System.out.println(s.getName() + "," + s.getChinese() + "," + s.getMath() + "," + s.getEnglist());
            String ss = s.getName() + "," + s.getChinese() + "," + s.getMath() + "," + s.getEnglist();
            bw.write(ss);
            bw.newLine();
            bw.flush();
        }
        bw.close();

    }
}
