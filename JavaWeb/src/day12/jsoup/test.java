package day12.jsoup;


import java.io.*;
import java.util.*;

public class test {
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
            int chnese = sc.nextInt();
            s.setChinese(chnese);
            System.out.println("数学成绩：");
            int math = sc.nextInt();
            s.setMath(math);
            System.out.println("英语成绩：");
            int english = sc.nextInt();
            s.setEnglish(english);
            list.add(s);
        }
        System.out.println(list);
        //int result = (a + b + c) / 5;
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\ideaspacework\\JavaWeb\\src\\day12\\jsoup\\a.txt"));

        for (Student stu : list) {
            StringBuilder sb = new StringBuilder();
            System.out.println(stu);
            sb.append(stu.getName()).append(stu.getId()).append(stu.getChinese()).append(stu.getMath()).append(stu.getEnglish());
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();


    }
}


