package com.zps.domain;

public class News {


    private String title; // 新闻标题
    private String article; // 新闻内容
    private String publishTime; // 新闻发布时间
    private String keyword; // 新闻关键字
    private String author; // 新闻作者

    public News() {
    }

    public News(String title, String article, String publishTime, String keyword, String author) {
        this.title = title;
        this.article = article;
        this.publishTime = publishTime;
        this.keyword = keyword;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", keyword='" + keyword + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
