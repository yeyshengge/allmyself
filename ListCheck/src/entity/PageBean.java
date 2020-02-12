package entity;

import java.util.List;

public class PageBean<T> {
    private int totalCount;   //总记录数
    private int totalepage;   //总页码
    private List<T> list;     //每页的数据
    private int currentPage;  //当前页码
    private int rows;         //每页显示的记录数

    public PageBean() {
    }

    public PageBean(int totalCount, int totalepage, List<T> list, int currentPage, int rows) {
        this.totalCount = totalCount;
        this.totalepage = totalepage;
        this.list = list;
        this.currentPage = currentPage;
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalepage() {
        return totalepage;
    }

    public void setTotalepage(int totalepage) {
        this.totalepage = totalepage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalepage=" + totalepage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
