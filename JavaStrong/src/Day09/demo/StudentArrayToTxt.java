package Day09.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
E:\ideaspacework\JavaStrong\src\Day09\java.txt
 */
public class StudentArrayToTxt {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student("001", "刘德华", 45, "上海");
        Student s2 = new Student("002", "张学友", 40, "北京");
        Student s3 = new Student("003", "黎明", 35, "南京");
        Student s4 = new Student("004", "古天乐", 42, "长沙");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //System.out.println(list);
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).getId()+","+list.get(i).getName()+","+list.get(i).getAge()+","+list.get(i).getAddress());
            bw.newLine();
            bw.flush();
        }

        bw.close();

    }
}
