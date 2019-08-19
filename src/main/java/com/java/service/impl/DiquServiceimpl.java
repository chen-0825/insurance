package com.java.service.impl;

import com.java.mapper.DiquMapper;
import com.java.pojo.Area;
import com.java.pojo.City;
import com.java.pojo.Province;
import com.java.service.DiquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiquServiceimpl implements DiquService {
    @Autowired
    private DiquMapper diquMapper;
    @Override
    public List<Province> selProvince() {
        return diquMapper.selProvince();
    }

    @Override
    public List<City> selCity(String codeP) {
        return diquMapper.selCity(codeP);
    }

    @Override
    public List<Area> selArea(String codeC) {
        return diquMapper.selArea(codeC);
    }

    @Override
    public String finProvince(String codeP) {
        return diquMapper.finProvince(codeP);
    }

    @Override
    public String finCity(String codeC) {
        return diquMapper.finCity(codeC);
    }

    @Override
    public String finArea(String codeA) {
        return diquMapper.finArea(codeA);
    }
}
