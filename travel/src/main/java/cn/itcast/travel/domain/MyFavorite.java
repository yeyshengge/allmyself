package cn.itcast.travel.domain;

import java.util.Date;

public class MyFavorite {

    private int rid;
    private Date date;
    private int uid;

    public MyFavorite() {
    }

    public MyFavorite(int rid, Date date, int uid) {
        this.rid = rid;
        this.date = date;
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "MyFavorite{" +
                "rid=" + rid +
                ", date=" + date +
                ", uid=" + uid +
                '}';
    }
}

