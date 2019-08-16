package com.java.mapper;

import com.java.pojo.HotCity;
import com.java.pojo.ZiCity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface QuoteMapper {
    //查找热门城市
    List<HotCity> findHotCity();

    //根据中文模糊查询
    List<ZiCity> findCityByName(String city);

    //根据拼音模糊查询
    List<ZiCity> findCityByPinyin(String city);
}
