package com.zps.service.impl;

import com.zps.dao.IndexDao;
import com.zps.dao.impl.IndexDaoImpl;
import com.zps.domain.Movice;
import com.zps.domain.PageBean;
import com.zps.service.IndexService;

import java.util.List;

public class IndexServiceImpl implements IndexService {
    private IndexDao d = new IndexDaoImpl();

    @Override
    public PageBean<Movice> findList(int currentPage, int pageSize, String searchName, String kind) {
        PageBean<Movice> pb = new PageBean<>();
        pb.setKind(kind);
        if ("".equals(kind) || kind == null || kind.length() < 0) {
            kind = "null";
        }
        switch (kind) {
            case "null":
                kind = "%";
                break;
            case "story":
                kind = "剧情";
                break;
            case "panic":
                kind = "恐怖";
                break;
            case "action":
                kind = "动作";
                break;
            case "kehuan":
                kind = "科幻";
                break;
            case "xuanyi":
                kind = "悬疑";
                break;

        }

        int count = d.findCount(pageSize, searchName, kind);


        int countPage = count / pageSize == 0 ? (count / pageSize) : ((count / pageSize) + 1);

        int start = (currentPage - 1) * pageSize;
        List<Movice> list = d.findList(start, pageSize, searchName, kind);
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        pb.setTotalPage(countPage);
        pb.setTotalCount(count);
        pb.setList(list);
        System.out.println("pb-" + pb);
        return pb;
    }

    @Override
    public Movice into(int id) {
        Movice m = d.into(id);
        return m;
    }
}
