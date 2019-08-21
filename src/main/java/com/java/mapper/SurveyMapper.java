package com.java.mapper;

import com.java.pojo.Survey;
import java.util.List;

public interface SurveyMapper {

    //增
    int add(Survey survey);

    //删
    int delete(String[] id);

    //改
    int update(Survey survey);

    //查所有
    List<Survey> findAll();

    //查单条
    Survey findOne(Survey survey);
}
