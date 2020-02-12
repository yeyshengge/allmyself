package Day10.work;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/*
第三题:模拟用户登录
	1.手动创建一个 以 .properties结尾的文件,手动添加 用户名 和 密码的键值对数
	2.把该文件中的数据加载到集合
	3.然后再键盘录入一个用户名和密码
		如果从properties文件中读到的数据和键盘录入的数据一样就提示登录成功
		如果不一样,请分别提示 是用户名错误或者密码错误
		E:\ideaspacework\JavaStrong\src\Day10\work\prop.properties
 */
public class Subject03 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader(new File("E:\\ideaspacework\\JavaStrong\\src\\Day10\\work\\prop.properties"));
        prop.load(fr);
        System.out.println(prop);

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String pswd = sc.nextLine();

        Set<String> s1 = prop.stringPropertyNames();
        int a = 0;
        for (String ss : s1) {
            if (username.equals(ss)) {
                if (prop.getProperty(ss).equals(pswd)) {
                    System.out.println("登陆成功");
                    break;
                } else {
                    System.out.println("密码错误");
                }
            } else {
                a++;
            }
        }
        if (a == s1.size()) {
            System.out.println("用户名错误");
        }

    }

}
