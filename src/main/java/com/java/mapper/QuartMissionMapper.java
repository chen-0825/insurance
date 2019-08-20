package com.java.mapper;

import com.java.pojo.AccessInfo;
import com.java.pojo.ExpirationInfo;
import com.java.pojo.HotCity;
import com.java.pojo.ZiCity;

import java.util.List;

public interface QuartMissionMapper {
    //查找到期的车险
    List<ExpirationInfo> findSevenDaysToEnding(String ending_date);

    //查找下月到期车险
    List<ExpirationInfo> sendToNextMonth(String ending_date);
}
