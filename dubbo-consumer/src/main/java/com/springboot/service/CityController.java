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

    @Reference(version = "1.0.0")
    CityService cityService;

    public void printCity() {
//        String cityName = "湖北省孝感市";
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

}
