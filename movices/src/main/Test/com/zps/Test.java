package com.zps;

import com.zps.util.JUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://www.ygdy8.net/html/gndy/dyzz/index.html").ignoreContentType(true).get();
        String json = doc.select("body").html();
        json = JUtil.updateJson(json);
        JSONObject json_1=new JSONObject();



    }
}
