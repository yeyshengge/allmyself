package com.zps.es;

import com.zps.es.entity.Article;
import com.zps.es.repositories.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * Created by zps on 2019/12/15 14:58
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex() {
        template.createIndex(Article.class);
    }

    @Test
    public void addDocument() {
        for (long i = 2; i < 30; i++) {

            Article article = new Article();
            article.setId(i);
            article.setTitle("第7章 Spring Boot集成模板引擎" + i);
            article.setContent("因为Spring Boot其实是对Spring生态的封装整合打包，以简化开发中使用Spring框架。" + (char) i);

            articleRepository.save(article);
        }
    }


    @Test
    public void deleteDocument() {
        //可以根据id跟Article对象来删除
        articleRepository.deleteById(1l);
    }

    @Test
    public void updateDocument() {
        //其实就是先删除在添加,保持id不变，会自动替换
        Article article = new Article();
        article.setId(1l);
        article.setTitle("第8章 Spring Boot集成模板引擎");
        article.setContent("因为Spring Boot其实是对Spring生态的封装整合打包，以简化开发中使用Spring框架。");

        articleRepository.save(article);
    }

    @Test
    public void findAll() {
        Iterable<Article> articles = articleRepository.findAll();
        articles.forEach(a -> System.out.println(a));
    }

    @Test
    public void findById() {
        Optional<Article> optional = articleRepository.findById(1L);
        //通过get()拿到数据
        Article article = optional.get();
        System.out.println(article);
    }

    @Test
    public void findByTitle() {
        List<Article> list = articleRepository.findByTitle("模板");
        list.stream().forEach(a -> System.out.println(a));
    }


    @Test
    public void findByTitleAndContent1() {
        List<Article> list = articleRepository.findByTitleAndContent("引擎", "封装");
        list.stream().forEach(a -> System.out.println(a));

    }

    @Test
    public void findByTitleAndContent2() {
        //设置分页的api
        Pageable pageable = PageRequest.of(0, 15);
        List<Article> list = articleRepository.findByTitleAndContent("引擎", "封装", pageable);
        list.stream().forEach(a -> System.out.println(a));
    }

    @Test
    public void nativeQueryString() {
        //原生查询方法
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                //查询构造器 查询字段
                .withQuery(QueryBuilders.queryStringQuery("打包封装").defaultField("content"))
                //分页
                .withPageable(PageRequest.of(0, 15))
                .build();
        List<Article> list = template.queryForList(query,Article.class);
        list.stream().forEach(a -> System.out.println(a));
    }

}
