package com.springboot.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.domain.City;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/5/29.
 */
@Component
public class CityController {

    // reference引用provider中注册暴露的接口，接口名需要一致，不然则无法实现相对应的具体数据操作
    @Reference(version = "1.0.0")
    CityService cityService;

    public void printCity() {
        String cityName = "孝感市";
        City city = cityService.findCityByName(cityName);
        System.out.println(city.toString());
    }

    public String getCities() {
        List<City> cityList = cityService.findAllCity();
        StringBuilder builder = new StringBuilder();
        for (City city : cityList) {
            builder.append(city.toString()).append("\n");
        }
        return builder.toString();
    }

    public List<City> getCityList() {
        return cityService.findAllCity();
    }

    public City getCityByName(String cityName) {
        return cityService.findCityByName(cityName);
    }

}
