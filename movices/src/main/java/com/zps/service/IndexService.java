package com.zps.service;

import com.zps.domain.Movice;
import com.zps.domain.PageBean;

public interface IndexService {
    PageBean<Movice> findList(int currentPage, int pageSize, String searchName, String kind);

    Movice into(int id);

}
