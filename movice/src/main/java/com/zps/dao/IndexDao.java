package com.zps.dao;

import com.zps.domain.Movice;

import java.util.List;

public interface IndexDao {
    List<Movice> findList(int start, int pageSize, String searchName, String kind);

    int findCount(int pageSize, String searchName, String kind);

    Movice into(int id);

}
