package com.java.service;

import com.java.pojo.Survey;

import java.util.List;

public interface SurveyService {
    //增
    int add(Survey survey);

    //删
    int delete(Survey survey);

    //改
    int update(Survey survey);

    //查所有
    List<Survey> findAll();
}
