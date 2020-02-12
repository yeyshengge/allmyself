package day12.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class JsoupMethod {
    public static void main(String[] args) throws IOException {
        //parse(File in,String charstName) 方法一
        //parse(String html)
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<students>\n" +
                "    <student id=\"1\">\n" +
                "        <name>张三</name>\n" +
                "        <age>18</age>\n" +
                "        <gender>male</gender>\n" +
                "    </student>\n" +
                "    <student id=\"2\">\n" +
                "        <name>李四</name>\n" +
                "        <age>14</age>\n" +
                "        <gender>female</gender>\n" +
                "    </student>\n" +
                "\n" +
                "</students>";
        Document document = Jsoup.parse(str);
        //System.out.println(document);

        //parse(url,timeout)
        URL url = new URL("https://www.dytt8.net");
        Document doc = Jsoup.parse(url, 5000);
        System.out.println(doc);
        Elements a = doc.getElementsByTag("a");

    }
}
