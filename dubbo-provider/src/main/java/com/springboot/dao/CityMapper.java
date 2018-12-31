package com.springboot.dao;

import com.springboot.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/6/3.
 */
@Mapper
public interface CityMapper {

    @Select("select * from city")
    List<City> findAllCity();

    /**
     * concat连接字符串实现like模糊查询
     * @param cityName
     * @return
     */
    @Select("select * from city where cityName like concat('%',#{cityName},'%')")
    City findCityByName(@Param("cityName") String cityName);


}
