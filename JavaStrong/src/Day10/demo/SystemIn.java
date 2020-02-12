package Day10.demo;

import java.io.*;

/*
in
public static final InputStream in“标准”输入流。 该流已经打开，准备提供输入数据。
通常，该流对应于键盘输入或由主机环境或用户指定的另一个输入源。
字节打印流
 */
public class SystemIn {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader isr = new InputStreamReader(in);
       /* int read;
        while ((read = isr.read()) != -1) {
            System.out.print((char) read);
        }*/
        BufferedReader br = new BufferedReader(isr);
        //BufferedReader br = new BufferedReadernew InputStreamReader(System.in));

        String a;
        while ((a=br.readLine())!=null){
            System.out.println(a);
        }

    }
}
