package com.java.service;

import com.java.pojo.ExpirationInfo;

import java.util.List;

public interface QuartMissionService {

    //查找到期的车险
    List<ExpirationInfo> findSevenDaysToEnding(String ending_date);

    //查找下月到期车险
    List<ExpirationInfo> sendToNextMonth(String ending_date);
}
