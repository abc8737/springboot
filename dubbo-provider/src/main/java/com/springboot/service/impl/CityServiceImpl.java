package com.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.dao.CityMapper;
import com.springboot.domain.City;
import com.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/5/28.
 */
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public City findCityByName(String cityName) {
        String city = cityName != null ? cityName : "城市名未知";
        return new City(1L, 2L, city, "地处中国中部");
    }

    @Override
    public List<City> findAllCity() {
        return cityMapper.findAllCity();
    }
}
