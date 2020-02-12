package com.zps.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by zps on 2019/12/15 14:46
 */
//都是一些约束
@Document(indexName = "spring_es", type = "article") //文档对象 （索引信息、文档类型 ）
@Data
public class Article {

    @Id  //文档主键 唯一标识
    @Field(type = FieldType.Long, store = true)//每个文档的字段配置（类型、是否分词、是否存储、分词器 ）
    private Long id;
    @Field(type = FieldType.text, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String title;
    @Field(type = FieldType.text, store = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String content;
    /*
    其中，注解解释如下：
    @Document(indexName="spring_es",type="article")：
    indexName：索引的名称（必填项）
    type：索引的类型
    @Id：主键的唯一标识
    @Field(index=true,analyzer="ik_smart",store=true,searchAnalyzer="ik_smart",type = FieldType.text)
    index：是否设置分词
    analyzer：存储时使用的分词器
    searchAnalyze：搜索时使用的分词器
    store：是否存储
    type: 数据类型
     */
}
