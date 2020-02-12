package com.zps.service;

import com.zps.domain.City;
import com.zps.domain.Part;

import java.util.List;

public interface ProvinceService {
    List<City> chang(String value);

    List<Part> city(String city);
}
