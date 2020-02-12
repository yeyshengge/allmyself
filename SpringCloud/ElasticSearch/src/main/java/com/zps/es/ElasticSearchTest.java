package com.zps.es;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zps.pojo.Article;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import javax.swing.tree.ExpandVetoException;
import java.net.InetAddress;

public class ElasticSearchTest {

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
     * 创建一个索引
     *
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        // 创建Client连接对象
        Settings settings = Settings.builder()
                //添加集群名称
                .put("cluster.name", "my-elasticsearch").build();
        //创建客户端Client对象
        TransportClient client = new PreBuiltTransportClient(settings);
        //设置参数
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9302));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9303));

        //获取管理员权限创建一个索引为hello
        client.admin().indices().prepareCreate("hello").get();

        //关闭客户端
        client.close();

    }


    /**
     * 创建一个mappings
     */
    @Test
    public void test02() throws Exception {
        //创建client连接对象
        Settings settings = Settings.builder().put("cluster.name", "my-elasticsearch").build();

        //创建client对象
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9302))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9303));

   /*{
	"mapping":{
		"article":{
			"properties":{
				"id":{
					"type":"long",
					"store":true
				},
				"title":{
					"type":"text",
					"store":true,
					"index":true,
					"analyzer":"ik_smart"
				},
				"content":{
					"type":"text",
					"index":true,
					"store":true,
					"analyzer":"ik_smart"
				}
			}
		}
	}
}*/
        //创建mappings的json字符串
        XContentBuilder builder = XContentFactory.jsonBuilder()
                //开启一个大括号
                .startObject()
                .startObject("article")
                .startObject("properties")
                .startObject("id")
                //设置字段名称跟值
                .field("type", "long")
                .field("store", "true")
                //关闭大括号
                .endObject()
                .startObject("title")
                .field("type", "text")
                .field("index", "true")
                .field("store", "true")
                .field("analyzer", "ik_smart")
                .endObject()
                .startObject("content")
                .field("type", "text")
                .field("index", "true")
                .field("store", "true")
                .field("analyzer", "ik_smart")
                .endObject()
                .endObject()
                .endObject()
                .endObject();

        client.admin().indices().preparePutMapping("hello").setType("article").setSource(builder).get();

        client.close();


    }

    /**
     * 创建文档
     */
    @Test
    public void test03() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", "my-elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9302))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9303));

        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("id", "3")
                .field("title", "习近平将出席澳门回归20周年大会  \"一国两制\"铸辉")
                .field("content", "求是:中国经济稳中向好、长期向好基本趋势没有改变")
                .endObject();

        client.prepareIndex().setIndex("hello").setId("3").setType("article").setSource(builder).get();
        client.close();
    }


    /**
     * jackson转换器
     */
    @Test
    public void test04() throws Exception {
        Article article = new Article();
        article.setId("2");
        article.setTitle("今天的温度");
        article.setContent("好冷啊");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(article);

        //prepareIndex的有参构造("Index","Type")
        client.prepareIndex("hello", "article").setSource(json).setId("2").get();
        client.close();
    }

    @Test
    public void test05() throws Exception {
        for (int i = 4; i < 100; i++) {
            Article article = new Article();
            article.setId(i+"");
            article.setTitle("春运没抢到票怎么办？超实用购票指南来了"+i);
            article.setContent("确保经济实现量的合理增长和质的稳步提升"+i);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(article);

            //prepareIndex的有参构造("Index","Type")
            client.prepareIndex("hello", "article").setSource(json).setId(i+"").get();
        }
        client.close();
    }


    /**
     * 使用字符串添加mapping
     *
     * @throws Exception
     */
    @Test
    public void test22() throws Exception {
        //创建client连接对象
        Settings settings = Settings.builder().put("cluster.name", "my-elasticsearch").build();
        //创建client对象
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9302))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9303));
        /*
        "mapping":{
		"article":{
			"properties":{
				"id":{
					"type":"long",
         */
        //不能双引号嵌套单引号，只能转义
        String mappings = "{\"article\":{\"properties\":{\"id\":{\"type\":\"long\",\"store\":\"true\"}}}}";

        client.admin().
                indices().
                preparePutMapping("demo").
                setType("article").
                setSource(mappings).
                get();

        client.close();


    }


    @Test
    public void test11() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", "my-elasticsearch").build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9301));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9302));
        client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9303));
        client.admin().indices().prepareCreate("test").get();
        client.close();

    }

}
