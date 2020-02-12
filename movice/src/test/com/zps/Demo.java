package com.zps;

import com.zps.domain.Movice;
import com.zps.domain.News;
import com.zps.util.JDBCUtils;
import com.zps.util.Spider;
import org.jsoup.nodes.Document;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // 实例化工具类对象
        Spider spider = new Spider();
        // 根据url获取文档（https://www.ygdy8.net/html/gndy/dyzz/list_23_2.html）
        for (int i = 1; i <3; i++) {

            Document doc = spider.loadDocumentData("https://www.ygdy8.net/html/gndy/dyzz/list_23_" + i + ".html");

            List<Movice> list = spider.parseDoc(doc);
            System.out.println(list);

           JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
            for (Movice m : list) {
                try {
                    String sql = "insert into movice (name,date,local,tname,ename,year,country,kind,language,word,showTime,dbSecore,longTime,actor,star,introduction,pigImg,smallImg,downloadSrc) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    jt.update(sql, m.getName(), m.getDate(), m.getLocal(), m.getTname(), m.getEname(), m.getYear(), m.getCountry(), m.getKind(), m.getLanguage(), m.getWord(), m.getShowTime(), m.getDbSecore(), m.getLongTime(), m.getActor(), m.getStar(), m.getIntroduction(), m.getPigImg(), m.getSmallImg(), m.getDownloadSrc());
                } catch (DataAccessException e) {
                    continue;
                }

            }

        }
    }
}

