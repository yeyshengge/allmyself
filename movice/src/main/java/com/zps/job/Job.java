package com.zps.job;

import com.zps.domain.Movice;
import com.zps.util.JDBCUtils;
import com.zps.util.Spider;
import com.zps.util.SpiderUpdate;
import org.jsoup.nodes.Document;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zps on 2019/12/19 16:12
 */
@Component
public class Job {
    //每天14点到14：55分，每5分钟执行一次：0 /1 * * * ?
    @Scheduled(cron = "0 0 * * * ?")
    public void test() throws Exception {
        SpiderUpdate spiderUpdate = new SpiderUpdate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 根据url获取文档（https://www.ygdy8.net/html/gndy/dyzz/list_23_2.html）
        //"https://www.ygdy8.net/html/gndy/dyzz/list_23_" + i + ".html"
        Document doc = spiderUpdate.loadDocumentData("https://www.dytt8.net/index0.html");
        List<Movice> list = spiderUpdate.parseDoc(doc);
        //System.out.println(list);
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        for (Movice m : list) {
            try {
                /*System.out.println(m.getDate());
                Date date = sdf.parse(m.getDate()+" 00:00:00");
                Long oldTime = date.getTime();
                Long nowTime = new Date().getTime() - 86400000;
                if (oldTime <= nowTime) {
                    System.out.println("跳过的电影名：" + m.getName());
                    continue;
                }*/
                String sql1 = "select count(*) from movice where name = ?";
                Long count = jt.queryForObject(sql1, Long.class, m.getName());
                if (count > 0) {
                    System.out.println("跳过的电影:" + m.getName());
                    continue;
                }
                System.out.println("保存的电影名：" + m.getName());
                try {
                    String sql = "insert into movice (name,date,local,tname,ename,year,country,kind,language,word,showTime,dbSecore,longTime,actor,star,introduction,pigImg,smallImg,downloadSrc) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    jt.update(sql, m.getName(), m.getDate(), m.getLocal(), m.getTname(), m.getEname(), m.getYear(), m.getCountry(), m.getKind(), m.getLanguage(), m.getWord(), m.getShowTime(), m.getDbSecore(), m.getLongTime(), m.getActor(), m.getStar(), m.getIntroduction(), m.getPigImg(), m.getSmallImg(), m.getDownloadSrc());
                } catch (DataAccessException e) {
                    continue;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}
