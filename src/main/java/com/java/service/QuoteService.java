package com.java.service;

import com.java.pojo.AccessInfo;
import com.java.pojo.HotCity;
import com.java.pojo.ZiCity;

import java.util.List;

/**
 * @author yql[ok;./
 * @create 2019-08-14 18:38
 */
public interface QuoteService {
    //查找热门城市
    List<HotCity> findHotCity();

    //根据中文模糊查询
    List<ZiCity> findCityByName(String city);

    //根据拼音模糊查询
    List<ZiCity> findCityByPinyin(String city);

    //添加访问信息
    int addAccessInfo(AccessInfo accessInfo);
}
