package Day12.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
static InetAddress getByName​(String host) 确定主机名称的IP地址。   该方法可以返回一个InetAddress对象。
String getHostAddress​() 返回文本显示中的IP地址字符串。
String getHostName​() 获取此IP地址的主机名。
 */
public class InetAdressDemo {
    public static void main(String[] args) throws UnknownHostException {
        //static InetAddress getByName​(String host) 确定主机名称的IP地址。   该方法可以返回一个InetAddress对象。
        InetAddress address = InetAddress.getByName("DESKTOP-41B247E");
        //String getHostAddress​() 返回文本显示中的IP地址字符串。
        String ip = address.getHostAddress();
        //String getHostName​() 获取此IP地址的主机名。
        String name = address.getHostName();

        System.out.println("计算机名称" + name);
        System.out.println("IP地址" + ip);

    }
}

/*
UDP： User Datagram Protocol 用户数据报协议
TCP： Transmission Control Protocol 传输控制协议
 */