package day12.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {


        String path = "D:\\ideaspacework\\JavaWeb\\src\\day12\\jsoup\\Demo.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());
        System.out.println(name);
       /* String text = name.text();
        System.out.println(text);*/
    }
}
