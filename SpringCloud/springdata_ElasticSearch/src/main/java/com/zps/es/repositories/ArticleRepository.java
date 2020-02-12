package com.zps.es.repositories;

import com.zps.es.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by zps on 2019/12/15 14:46
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {
    /**
     * 该接口里面实现了很多CRUD的方法
     */

    List<Article> findByTitle(String title);

    List<Article> findByTitleAndContent(String title, String content);

    //分页
    List<Article> findByTitleAndContent(String title, String content, Pageable pageable);

}
