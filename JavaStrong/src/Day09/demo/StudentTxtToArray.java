package Day09.demo;

import Day01.Work.A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
学生类文件到集合
E:\ideaspacework\JavaStrong\src\Day09\java.txt
 */
public class StudentTxtToArray {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        String a;
        while ((a = br.readLine()) != null) {
            String[] s = a.split(",");
            Student s1 = new Student();
            for (int i = 0; i < s.length; i++) {

                s1.setId(s[0]);
                s1.setName(s[1]);
                s1.setAge(Integer.valueOf(s[2]));
                s1.setAddress(s[3]);
            }
            list.add(s1);
        }
        br.close();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+","+list.get(i).getName() + "," + list.get(i).getAge()+","+list.get(i).getAddress());
        }

    }
}
