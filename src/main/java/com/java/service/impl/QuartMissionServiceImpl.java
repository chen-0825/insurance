package com.java.service.impl;

import com.java.mapper.QuartMissionMapper;
import com.java.pojo.ExpirationInfo;
import com.java.service.QuartMissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartMissionServiceImpl implements QuartMissionService {
    @Autowired
    private QuartMissionMapper quartMissionMapper;

    @Override
    public List<ExpirationInfo> findSevenDaysToEnding(String ending_date) {
        return  quartMissionMapper.findSevenDaysToEnding(ending_date);
    }

    @Override
    public List<ExpirationInfo> sendToNextMonth(String ending_date) {
        return quartMissionMapper.sendToNextMonth(ending_date);
    }
}
