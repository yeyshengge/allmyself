package com.zps.domain;

import java.util.List;

/**
 * Created by zps on 2019/12/29 21:26
 */
public class PageInfo<T> {
    private List<T> list;
    private String pages;
    private String prePage;
    private String total;

    public PageInfo() {
    }

    public PageInfo(List<T> list, String pages, String prePage, String total) {
        this.list = list;
        this.pages = pages;
        this.prePage = prePage;
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrePage() {
        return prePage;
    }

    public void setPrePage(String prePage) {
        this.prePage = prePage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", pages='" + pages + '\'' +
                ", prePage='" + prePage + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
