package com.java.service.impl;

import com.java.mapper.QuoteMapper;
import com.java.pojo.HotCity;
import com.java.pojo.ZiCity;
import com.java.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteMapper quoteMapper;

    @Override
    public List<HotCity> findHotCity() {
        return quoteMapper.findHotCity();
    }

    @Override
    public List<ZiCity> findCityByName(String city) {
        return quoteMapper.findCityByName(city);
    }

    @Override
    public List<ZiCity> findCityByPinyin(String city) {
        return quoteMapper.findCityByPinyin(city);
    }
}