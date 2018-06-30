package com.springboot.dao;

import com.springboot.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/6/3.
 */
@Mapper
public interface CityMapper {

    @Select("select * from city")
    List<City> findAllCity();
}
