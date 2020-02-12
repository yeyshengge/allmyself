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

public class ElementMethod {
    public static void main(String[] args) throws IOException {
        String path = "D:\\ideaspacework\\JavaWeb\\src\\day12\\jsoup\\Demo.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        /*
        <students>
            <student id="s1">
                <name>张三</name>
                <age>18</age>
                <gender>male</gender>
            </student>
            <student id="s2">
                <name>李四</name>
                <age>14</age>
                <gender>female</gender>
            </student>
        </students>
         */
        Elements student = document.getElementsByTag("student");
        Element element = student.get(0);
        System.out.println(element);
        System.out.println("---------");
        Elements name = element.getElementsByTag("name");
        System.out.println(name);
        System.out.println("--------");
        System.out.println(name.text());
        System.out.println(name.html());
        System.out.println("--------");
        //获取属性值
        String id = element.attr("id");
        System.out.println(id);

    }
}
