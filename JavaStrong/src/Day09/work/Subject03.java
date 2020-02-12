package Day09.work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
题目三:分析以下需求，并用代码实现
	实现一个验证程序运行次数的小程序，要求如下：
	1.当程序运行超过3次时给出提示:本软件只能免费使用3次,欢迎您注册会员后继续使用~
	2.程序运行演示如下:
		第一次运行控制台输出: 欢迎使用本软件,第1次使用免费~
		第二次运行控制台输出: 欢迎使用本软件,第2次使用免费~
		第三次运行控制台输出: 欢迎使用本软件,第3次使用免费~
		第四次及之后运行控制台输出:本软件只能免费使用3次,欢迎您注册会员后继续使用~
		(使用的次数应该存在一个文本文件中,每次启动程序都应该更改文件里的数据)
 */
public class Subject03 {
    public static void main(String[] args) throws Exception {
        /*
            分析:
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
        BufferedReader br = new BufferedReader( new FileReader("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));
        String line = br.readLine();

        br.close();

        //转成 int类型
        int number = Integer.parseInt(line);
        System.out.println(number);
        //就应该对读取到的数据进行判断
        if(number > 3){
            System.out.println("本软件只能免费使用3次,欢迎您注册会员后继续使用~");
            return; //结束所在的方法
        }

        //然后把该数字++再通过输出流把数据写入到文件
        System.out.println("欢迎使用本软件,第"+number+"次使用免费~");
        number++;
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\ideaspacework\\JavaStrong\\src\\Day09\\java.txt"));

        //写数据,写几次???
        bw.write(number+"");  //为了保证数据的原样性,必须把数字当做是字符串写入
        bw.close();
    }
}
