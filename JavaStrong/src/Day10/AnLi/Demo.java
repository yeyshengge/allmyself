package Day10.AnLi;

import java.io.*;

/*
E:\ideaspacework\JavaStrong\src\Day10\AnLi
 1,首先应该手动的创建一个文件,该文件记录该软件使用的次数
                2,每次启动程序的时候,就应该先把文件中的数据读取出来
                3,怎么读?
                    字符缓冲流,一次读取一行 (不需要循环,读取一次即可)
                4,就应该对读取到的数据进行判断
                    判断之前需要把读取到的数据 转成 int类型
                    如果该数字大于3,直接输出   本软件只能免费使用3次,欢迎您注册会员后继续使用~
                    如果该数字小于3
                        应该提示还有几次
                        然后把该数字++再通过输出流把数据写入到文件
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader br  =new BufferedReader(new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day10\\AnLi\\软件.txt"));
        String s = br.readLine();
        int i = Integer.valueOf(s);
        br.close();
        if(i>3){
            System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
        }else {
            System.out.println("你还有"+(3-i)+"次使用机会");
            i++;
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day10\\AnLi\\软件.txt"));
        bw.write(i+"");
        bw.close();
    }
}
