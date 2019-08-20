package com.java.mapper;

import com.java.pojo.Area;
import com.java.pojo.City;
import com.java.pojo.Province;

import java.util.List;


public interface DiquMapper {
    //查询省
    public List<Province> selProvince();

    //查询市
    public List<City> selCity(String codeP);

    //查询地区
    public List<Area> selArea(String codeC);

    //添加成功的是代码 要添加汉字

    public String finProvince(String codeP);
    public String finCity(String codeC);
    public String finArea(String codeA);

}
