package com.zps.util;

import com.zps.domain.Movice;
import com.zps.domain.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Spider {
    // 获取页面加载内容
    public Document loadDocumentData(String url) {

        // 创建文档对象
        Document doc = null;
        // 根据url将某页信息转换成文档
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 返回文档
        return doc;
    }

    // 获取a标签中的href的内容
    public List<Movice> parseDoc(Document doc) {
        // 实例化list
        List<Movice> list = new ArrayList<Movice>();
        // 根据指定class获取对象（这里我们查看页面源码，选取了一个class为 new_top 的新闻 列表）
        Elements elements = doc.getElementsByClass("bd3r");
        // 根据指定的标签获取连接内容（这里选取的是a标签中的内容）
        Elements links = elements.get(0).getElementsByTag("table");
        for (int i = 0; i < links.size(); i++) {

            try {
                Movice m = new Movice();
                Elements tr = links.get(i).getElementsByTag("tr");
                int index = 0;
                for (Element element : tr) {
                    if (++index == 1) {
                        continue;
                    }
                    if (index == 2) {
                        m.setName(element.text());
                        System.out.println("电影名***" + element.text());//这里输出电影名称，日期，介绍
                    }
                    if (index == 3) {
                        m.setDate(element.text().substring(5,24));
                        //System.out.println("日期***" + element.text());//这里输出电影名称，日期，介绍
                    }
                    if (index == 4) {

                        //System.out.println("介绍***" + element.text());//这里输出电影名称，日期，介绍
                    }
                }
                Elements linkb = elements.get(0).getElementsByTag("b");
                //for (int j = 0; j < linkb.size(); j++) {

                Elements a = linkb.get(i).getElementsByTag("a");

                //https://www.dytt8.net/html/gndy/dyzz/list_23_2.html
                String url = "https://www.dytt8.net" + a.get(0).attr("href");
                m.setLocal(url);
                //System.out.println("详情页地址---" + url);
                Spider spider = new Spider();
                Document ddd = spider.loadDocumentData(url);
                // 根据指定class获取对象（这里我们查看页面源码，选取了一个class为 new_top 的新闻 列表）
                Elements elements2 = ddd.getElementsByClass("co_content8");
                // 根据指定的标签获取连接内容（这里选取的是a标签中的内容）
                Elements links2 = elements2.get(0).getElementsByTag("p");
                String[] split = links2.text().split("◎");
                int d = 0;
                for (String s : split) {
                    switch (++d) {
                        case 1:

                            //System.out.println("我是电影名---" + s);
                            break;
                        case 2:
                            m.setTname(s.substring(5));
                            //System.out.println("我是佚名---" + s);
                            break;
                        case 3:
                            m.setEname(s.substring(5));
                            //System.out.println("我是片名---" + s);
                            break;
                        case 4:
                            m.setYear(s.substring(5));
                            //System.out.println("我是年代---" + s);
                            break;
                        case 5:
                            m.setCountry(s.substring(5));
                           // System.out.println("我是产地---" + s);
                            break;
                        case 6:
                            m.setKind(s.substring(5));
                           // System.out.println("我是类别---" + s);
                            break;
                        case 7:
                            m.setLanguage(s.substring(5));
                          //  System.out.println("我是语言---" + s);
                            break;
                        case 8:
                            m.setWord(s.substring(5));
                          //  System.out.println("我是字幕---" + s);
                            break;
                        case 9:
                            m.setShowTime(s.substring(5));
                            //System.out.println("我是上映时间---" + s);
                            break;
                        case 11:
                            m.setDbSecore(s.substring(5));
                           // System.out.println("我是豆瓣评分---" + s);
                            break;
                        case 15:
                            m.setLongTime(s.substring(5));
                            //System.out.println("我是片长---" + s);
                            break;
                        case 16:
                            m.setActor(s.substring(5));
                            //System.out.println("我是导演---" + s);
                            break;
                        case 18:
                            m.setStar(s.substring(5));
                            //System.out.println("我是主演---" + s);
                            break;
                        case 20:
                            m.setIntroduction(s.substring(5));
                           // System.out.println("我是简介---" + s);
                            break;
                    }
                }
                d = 0;
                Elements pigimg = links2.get(0).getElementsByTag("img");
                int flag = 0;

                for (Element element : pigimg) {
                    flag++;
                    if (flag == 1) {
                        m.setPigImg(element.attr("src"));
                        //System.out.println("大图###" + element.attr("src"));
                    }
                    if (flag == 2) {
                        m.setSmallImg(element.attr("src"));
                        //System.out.println("小图###" + element.attr("src"));
                    }
                }
                flag = 0;
                index = 0;
                /*Elements a1 = links2.get(0).getElementsByTag("a");
                System.out.println("---"+a1);
                String download = a1.attr("href");
                System.out.println(download);
                m.setDownloadSrc(download);
                list.add(m);*/
                Elements t = elements2.get(0).getElementsByTag("table");
                Elements a1 = t.get(0).getElementsByTag("a");
                //System.out.println(a1.get(0).attr("href"));
                m.setDownloadSrc(a1.get(0).attr("href"));
                list.add(m);
            } catch (Exception e) {
                continue;
            }
        }

        return list;
    }

    // 按照要求获取news对象
    public News parseDetaile(Document doc) {
        // System.out.println(doc);
        // 实例化news对象
        News news = new News();
        // 按照class获取文档对象 main_title的文本信息，并将该信息存入title中
        String title = doc.getElementsByClass("main_title").text();
        // 查照选择器data-sourse后面的.data信息，并将该信息存入publishTime中
        String publishTime = doc.select(".data-sourse > .data").text();
        // 按照class获取文档对象 caricle 的文本信息，并将该信息存入 article 中
        String article = doc.getElementsByClass("article").text();
        // 按照class获取文档对象 keyword 的文本信息，并将该信息存入 keyword 中
        String keyword = doc.getElementsByClass("keyword").text();
        // 按照class获取文档对象  show_author 的文本信息，并将该信息存入 author 中
        String author = doc.getElementsByClass("show_author").text();
        // 将以上信息填充到news对象中
        news.setTitle(title);
        news.setPublishTime(publishTime);
        news.setArticle(article);
        news.setKeyword(keyword);
        news.setAuthor(author);
        return news;
    }
}


