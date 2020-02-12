package Day10.demo;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //seria();
        reseria();

        /*
        InvalidClassException: Day10.demo.Person; local class incompatible:
        stream classdesc serialVersionUID = 7471664820285456723,
        local class serialVersionUID = 6196661657209670947
        当序列化运行时检测到类中的以下问题之一时抛出。
        类的串行版本与从流中读取的类描述符的类型不匹配
        该类包含未知的数据类型
        该类没有可访问的无参数构造函数

         */


    }

    //序列化
    public static void seria() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"));
        Person p1 = new Person("古天乐", 10);
        oos.writeObject(p1);
        oos.close();
    }

    //反序列化
    public static void reseria() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"));
        Object o = ois.readObject();
        Person p1 = (Person) o;
        System.out.println(p1.getName() + "," + p1.getAge());

    }


}
