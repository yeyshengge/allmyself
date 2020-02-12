package day12.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupTest {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.parse(new File("D:\\ideaspacework\\JavaWeb\\src\\day12\\jsoup\\Demo.xml"), "utf-8");
        Elements name = doc.getElementsByTag("name");
        for (Element element : name) {
            System.out.println(element);
        }
        System.out.println("-----");
        Elements s = doc.getElementsByAttributeValue("id", "s2");
        System.out.println(s.get(0).text());

    }
}
