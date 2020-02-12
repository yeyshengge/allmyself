package Day10.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*ObjectOutputStream​() 为完全重新实现ObjectOutputStream的子类提供一种方法，
不必分配刚刚被ObjectOutputStream实现使用的私有数据。
void writeObject​(Object obj) 将指定的对象写入ObjectOutputStream。*/


public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\ideaspacework\\JavaStrong\\src\\Day10\\java.txt"));
        Person p1 = new Person("张曼玉", 18);
        Person p2 = new Person("刘德华", 38);
        oos.writeObject(p1);
        oos.writeObject(p2);
        oos.close();
        //NotSerializableException  抛出一个实例需要一个Serializable接口。
        // 序列化运行时或实例的类可能会抛出此异常。 参数应该是类的名称。

    }
}
