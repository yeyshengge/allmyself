package Day15.work.subject01;

import javax.xml.crypto.Data;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
第一题:分析以下需求,并用代码实现
	1.定义一个Person类
	2.定义 姓名 和 年龄 两个成员变量,生成构造方法和对应的set get方法
	3.在该类中定义一个run()方法,打印:"我"+name+"是一个好人"
	4.在该类中定义一个show(Date date)方法,该方法执行时可以将时间转为符合我们阅读习惯的格式
		如:2019年01月08日 11:00:30
	5.在该类中定义一个copy(String fileName)方法,该方法可以接收一个文件的名称
		注意:在模块的根路径下已知有一个纯文本文档类型的文件,需要在该方法的内部
		将文件里的内容反转
		例如:
			源文件内容:
				种一颗树最好的时光是十年前
				其次好的时光就是现在

			方法执行之后文件里的内容
				其次好的时光就是现在
				种一颗树最好的时光是十年前

	6.在测试类中,通过反射的方式创建对象、获取方法、执行方法
 */
public class Subject01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class<Person> c = Person.class;
        Constructor<Person> cons = c.getConstructor();
        Person p1 = cons.newInstance();
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "张翩笙");
        //3.在该类中定义一个run()方法,打印:"我"+name+"是一个好人"
        Method run = c.getMethod("run");
        run.invoke(p1);
        //	4.在该类中定义一个show(Date date)方法,该方法执行时可以将时间转为符合我们阅读习惯的格式
        Method[] m = c.getDeclaredMethods();
        /*for(Method mm :m){
            System.out.println(mm);
        }*/
        //public void Day15.work.subject01.Person.show(java.util.Date)
        Method m1 = c.getMethod("show", Date.class);
        //m1.setAccessible(true);
        Date d = new Date();
        m1.invoke(p1, d);

        //	5.在该类中定义一个copy(String fileName)方法,该方法可以接收一个文件的名称
        //public void Day15.work.subject01.Person.copy(java.lang.String) throws java.io.IOException
        Method m2 = c.getMethod("copy", String.class);
        File f = new File("E:\\ideaspacework\\JavaStrong\\src\\Day15\\work\\subject01\\file.txt");
        m2.invoke(p1, f.getAbsolutePath());

    }
}
