package Day15.work.subject01;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //3.在该类中定义一个run()方法,打印:"我"+name+"是一个好人"
    public void run() {
        System.out.println("我" + name + "是一个好人");
    }

    //4.在该类中定义一个show(Date date)方法,该方法执行时可以将时间转为符合我们阅读习惯的格式
    //		如:2019年01月08日 11:00:30
    public void show(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
    }

    /*
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
     */
    public void copy(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        ArrayList<String> list = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
