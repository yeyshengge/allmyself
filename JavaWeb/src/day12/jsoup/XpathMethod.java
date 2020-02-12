package day12.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
public class XpathMethod {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = "D:\\ideaspacework\\JavaWeb\\src\\day12\\jsoup\\Demo.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        JXDocument jxDocument = new JXDocument(document);
        //获取所以stutent下的内容
        List<JXNode> jxNodes = jxDocument.selN("//student");

        //获取 student下名为name的标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");

        //获取name中属性为id的标签

        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }


    }
}
