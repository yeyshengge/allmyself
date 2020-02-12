package com.zps.domain;


@SuppressWarnings("all")
public class Movice {
    private Integer id;         //id
    private String name;    //电影名
    private String date;      //日期
    private String local;   //详情页
    private String tname;  //佚名
    private String ename;  //片名
    private String year;   //年代
    private String country;  //产地
    private String kind;   //种类
    private String language; //语言
    private String word;   //字幕
    private String showTime;   //上映时间
    private String dbSecore;   //豆瓣评分
    private String longTime;   //时长
    private String actor;      //导演
    private String star;       //演员
    private String introduction;  //简介
    private String pigImg;   //大图
    private String smallImg;   //小图
    private String downloadSrc;  //下载地址

    public Movice() {
    }

    public Movice(Integer id, String name, String date, String local, String tname, String ename, String year, String country, String kind, String language, String word, String showTime, String dbSecore, String longTime, String actor, String star, String introduction, String pigImg, String smallImg, String downloadSrc) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.local = local;
        this.tname = tname;
        this.ename = ename;
        this.year = year;
        this.country = country;
        this.kind = kind;
        this.language = language;
        this.word = word;
        this.showTime = showTime;
        this.dbSecore = dbSecore;
        this.longTime = longTime;
        this.actor = actor;
        this.star = star;
        this.introduction = introduction;
        this.pigImg = pigImg;
        this.smallImg = smallImg;
        this.downloadSrc = downloadSrc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getDbSecore() {
        return dbSecore;
    }

    public void setDbSecore(String dbSecore) {
        this.dbSecore = dbSecore;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPigImg() {
        return pigImg;
    }

    public void setPigImg(String pigImg) {
        this.pigImg = pigImg;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getDownloadSrc() {
        return downloadSrc;
    }

    public void setDownloadSrc(String downloadSrc) {
        this.downloadSrc = downloadSrc;
    }

    @Override
    public String toString() {
        return "Movice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", local='" + local + '\'' +
                ", tname='" + tname + '\'' +
                ", ename='" + ename + '\'' +
                ", year='" + year + '\'' +
                ", country='" + country + '\'' +
                ", kind='" + kind + '\'' +
                ", language='" + language + '\'' +
                ", word='" + word + '\'' +
                ", showTime='" + showTime + '\'' +
                ", dbSecore='" + dbSecore + '\'' +
                ", longTime='" + longTime + '\'' +
                ", actor='" + actor + '\'' +
                ", star='" + star + '\'' +
                ", introduction='" + introduction + '\'' +
                ", pigImg='" + pigImg + '\'' +
                ", smallImg='" + smallImg + '\'' +
                ", downloadSrc='" + downloadSrc + '\'' +
                '}';
    }
}
