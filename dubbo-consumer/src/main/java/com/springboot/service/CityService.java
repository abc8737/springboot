package com.springboot.service;

import com.springboot.domain.City;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/5/29.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

    List<City> findAllCity();
}
