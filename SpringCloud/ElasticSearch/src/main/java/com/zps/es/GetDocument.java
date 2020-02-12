package com.zps.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.Highlighter;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zps on 2019/12/15 10:26
 */
public class GetDocument {


    private TransportClient client;

    @Before
    public void setClient() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", "my-elasticsearch").build();
        client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9302))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9303));
    }

    /**
     * 抽取的方法
     *
     * @param queryBuilder
     */
    private void search(QueryBuilder queryBuilder) {
        SearchResponse searchResponse = client
                .prepareSearch("hello")
                .setTypes("article")
                //设置开始索引
                .setFrom(0)
                //设置查询个数
                .setSize(5)
                .setQuery(queryBuilder)
                //提交
                .get();

        long count = searchResponse.getHits().totalHits;
        System.out.println("总共查询到" + count + "条");

        Iterator<SearchHit> iterator = searchResponse.getHits().iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            System.out.println("已字符串返回" + searchHit.getSourceAsString());
            Map<String, Object> document = searchHit.getSource();
            System.out.println("-------遍历查找");
            System.out.println("id为" + document.get("id"));
            System.out.println("title为" + document.get("title"));
            System.out.println("content为" + document.get("content"));
        }
        //关闭流
        client.close();
    }

    private void search(QueryBuilder queryBuilder, String highLightFiled) {
        //高亮构建器
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //设置高亮显示的字段名
        highlightBuilder.field(highLightFiled);
        //设置前缀
        highlightBuilder.preTags("<em>");
        //设置后缀
        highlightBuilder.postTags("</em>");

        SearchResponse searchResponse = client
                .prepareSearch("hello")
                .setTypes("article")
                //设置开始索引
                .setFrom(0)
                //设置查询个数
                .setSize(5)
                //设置高亮显示的字段
                .highlighter(highlightBuilder)
                //设置查询构造器
                .setQuery(queryBuilder)
                //提交
                .get();

        long count = searchResponse.getHits().totalHits;
        System.out.println("总共查询到" + count + "条");

        Iterator<SearchHit> iterator = searchResponse.getHits().iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            System.out.println("已字符串返回" + searchHit.getSourceAsString());
            Map<String, Object> document = searchHit.getSource();
            System.out.println("-------遍历查找");
            System.out.println("id为" + document.get("id"));
            System.out.println("title为" + document.get("title"));
            System.out.println("content为" + document.get("content"));

            System.out.println("-------------高亮显示---------------");
            //获取高亮map
            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
            System.out.println("高亮显示的map集合" + highlightFields);
            HighlightField title = highlightFields.get("title");
            //获取高亮显示的内容，可能有多个
            Text[] fragments = title.getFragments();
            System.out.println("高亮显示的内容"+Arrays.toString(fragments));


        }
        //关闭流
        client.close();
    }

    /**
     * 根据query_string查询
     */
    @Test
    public void searchByQueryString() {

        QueryBuilder queryBuilder = QueryBuilders
                //搜索关键字
                .queryStringQuery("春运")
                //搜索字段 不配置代表全域
                .defaultField("title");
        search(queryBuilder, "title");

    }

    /**
     * 根据term进行查询
     */
    @Test
    public void searchByTerm() {
        //根据term进行查询，参数一是查询的字段位置，参数二为查询的关键词
        QueryBuilder queryBuilder = QueryBuilders.termQuery("title", "的");
        search(queryBuilder);
    }

    /**
     * 根据id进行查询
     */
    @Test
    public void searchQuery() {
        //QueryBuilders工具类会产生很多的查询构建器
        QueryBuilder queryBuilder = QueryBuilders
                //通过id进行查询
                .idsQuery()
                //可以批量设置id
                .addIds("1", "2");

        SearchResponse searchResponse = client.prepareSearch("hello").setTypes("article").setQuery(queryBuilder).get();

        long count = searchResponse.getHits().totalHits;
        System.out.println("总共查询到" + count + "条");

        Iterator<SearchHit> iterator = searchResponse.getHits().iterator();
        while (iterator.hasNext()) {
            SearchHit searchHit = iterator.next();
            System.out.println("已字符串返回" + searchHit.getSourceAsString());
            Map<String, Object> document = searchHit.getSource();
            System.out.println("-------遍历查找");
            System.out.println("id为" + document.get("id"));
            System.out.println("title为" + document.get("title"));
            System.out.println("content为" + document.get("content"));
        }
        //关闭流
        client.close();

    }
}
