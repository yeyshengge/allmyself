package Day10.relearn;

import java.io.*;

public class ObjectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\relearn\\test.txt"));
        Student s = new Student("张曼玉", 18);
        Student s2 = new Student("张玉", 28);
        oos.writeObject(s);
        oos.writeObject(s2);
        oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\relearn\\test.txt"));
        Object o2 = null;
        try {
            while ((o2 = ois.readObject()) != null) {
                Student ss2 = (Student) o2;
                System.out.println(ss2.getName() + "," + ss2.getAge());
            }
        } catch (EOFException e) {
            return;
        }
        ois.close();
    }
}
