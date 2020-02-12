package day12.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/*
   getElementById(String id) 根据id获取
   getElementByTag(Sting tagName)根据标签名称获取元素对象集合
   getElementByAttribute(String key)根据属性名称获取元素对象集合
   getElementByAttributeValue(String key,String value)根据对应的属性名属性值获取
 */

public class DocumentMethod {
    public static void main(String[] args) throws IOException {
        String path = "D:\\ideaspacework\\JavaWeb\\src\\day12\\jsoup\\Demo.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        // getElementById(String id) 根据id获取
        Element elementById = document.getElementById("s1");
        //System.out.println(elementById);

        //getElementByTag(Sting tagName)根据标签名称获取元素对象集合
        Elements name = document.getElementsByTag("name");
        //System.out.println(name);

        //getElementByAttribute(String key)根据属性名称获取元素对象集合
        Elements id = document.getElementsByAttribute("id");
        //System.out.println(id);

        //getElementByAttributeValue(String key,String value)根据对应的属性名属性值获取
        Elements id1 = document.getElementsByAttributeValue("id", "s1");
        System.out.println(id1);
    }
}
