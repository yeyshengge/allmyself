package cn.itcast;

import java.io.IOException;
import java.util.Scanner;

/**
 * 测试类
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        //1.创建ServiceManager实现类对象
        ServiceManager s = new ServiceManagerImpl();
        //2.从控制台录入一个端口号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入端口号：");
        String port = sc.next();
        //3.调用ServiceManager实现类对象的getServiceInfo方法，根据端口号，查询出对应的ServiceInfo对象；
        ServiceInfo serviceInfo = s.getServiceInfo(port);

        //4.判断第三步返回的结果，如果为null，则在控制台输出："您查询的端口号不存在";如果不为null，则打印该对象中的内容到控制台
        if(serviceInfo==null){
            System.out.println("不存在");
            return;
        }
        System.out.println(serviceInfo.getName()+" "+serviceInfo.getIp()+" "+serviceInfo.getPort()+" "+serviceInfo.getAppname());
    }
}
