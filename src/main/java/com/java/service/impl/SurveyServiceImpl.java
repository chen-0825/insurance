package com.java.service.impl;

import com.java.mapper.SurveyMapper;
import com.java.pojo.Survey;
import com.java.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    public SurveyMapper surveyMapper;

    public int  add(Survey survey) {
        return surveyMapper.add(survey);
    }

    public int delete(Survey survey) {
        return surveyMapper.delete(survey);
    }

    public int update(Survey survey) {
        return surveyMapper.update(survey);
    }

    public List<Survey> findAll() {
        return surveyMapper.findAll();
    }
}
