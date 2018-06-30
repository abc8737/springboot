package com.springboot.service;

import com.springboot.domain.City;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/5/28.
 */
public interface CityService {

    /**
     * 按照名字查找城市
     *
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);

    List<City> findAllCity();
}
