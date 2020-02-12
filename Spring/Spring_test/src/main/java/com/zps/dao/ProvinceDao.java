package com.zps.dao;

import com.zps.domain.City;
import com.zps.domain.Part;

import java.util.List;

public interface ProvinceDao {
    List<City> chang(String value);

    List<Part> city(String city);
}
