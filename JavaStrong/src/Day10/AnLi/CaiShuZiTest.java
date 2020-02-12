package Day10.AnLi;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*
E:\ideaspacework\JavaStrong\src\Day10\AnLi\cishu.txt
 */
public class CaiShuZiTest {
    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();
        FileReader fr = new FileReader(new File("E:\\ideaspacework\\JavaStrong\\src\\Day10\\AnLi\\cishu.txt"));
        prop.load(fr);
        fr.close();
        System.out.println(prop);
        String str = prop.getProperty("count");
        int i = Integer.valueOf(str);
        if(i>=3){
            System.out.println("游戏次数不足，请给18473825788转钱，一元一次哦");
        }else{
            CaiShuZi.caicaicai();
            i++;
        }
        FileWriter fw = new FileWriter(new File("E:\\ideaspacework\\JavaStrong\\src\\Day10\\AnLi\\cishu.txt"));
        prop.setProperty("count",Integer.toString(i));
        prop.store(fw,null);
        fw.close();
        System.out.println(prop);
    }
}
