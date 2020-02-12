package Day15.work.subject02;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
第二题:分析以下需求,并用代码实现
	1.已知一个类，定义如下：
		package com.itheima;
		public class DemoClass {
			private void run(String name) {
				System.out.println(name + "welcome to heima!");
			}
		}
		(1)写一个Properties格式的配置文件，配置类的完整名称、方法名称E:\ideaspacework\JavaStrong\src\Day15\work\subject02
		(2)写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，
		(3)用反射 的方式创建对象、获取方法、执行方法
 */
public class Subject02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties p = new Properties();
        //className=Day15.work.subject02.DemoClass
        //methodName=run

        FileReader fr = new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day15\\work\\subject02\\prop.txt");

        p.load(fr);
        fr.close();

        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");


        Class<?> c = Class.forName(className);

        Constructor<?> cons = c.getConstructor();
        Object o = cons.newInstance();

        Method m = c.getDeclaredMethod(methodName, String.class);
        m.setAccessible(true);
        m.invoke(o, "小东西");


    }
}
