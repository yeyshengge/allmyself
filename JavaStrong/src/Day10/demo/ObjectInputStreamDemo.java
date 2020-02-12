package Day10.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
protected  ObjectInputStream​() 为完全重新实现ObjectInputStream的子类提供一种方法，
不必分配刚刚被ObjectInputStream实现使用的私有数据。
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"));
        Object o = ois.readObject();
        Person p = (Person) o;
        System.out.println(p.getName() + "," + p.getAge());
        ois.close();
    }
}
