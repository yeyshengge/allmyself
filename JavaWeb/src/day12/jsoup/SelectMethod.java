package day12.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*
select(String cssQuery)  :  查询   String cssQuery:css样式
 */

/*
<students>
    <student id="s1">
        <name>
            <xing>张</xing>
            <ming>三</ming>
        </name>
        <age>18</age>
        <gender>male</gender>
    </student>
    <student id="s2">
        <name>李四</name>
        <age>14</age>
        <gender>female</gender>
    </student>
 */
public class SelectMethod {
    public static void main(String[] args) throws IOException {
        String path = "D:\\ideaspacework\\JavaWeb\\src\\day12\\jsoup\\Demo.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        //查询id为s1的信息
        Elements select = document.select("#s1");
        System.out.println(select);

        System.out.println("---------");
        Elements select1 = document.select("[id='s1'] >age");
        System.out.println(select1);

    }
}
