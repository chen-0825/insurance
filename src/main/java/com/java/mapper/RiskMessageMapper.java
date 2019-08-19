package com.java.mapper;

import com.java.pojo.Riskmessage;

import java.util.List;

public interface RiskMessageMapper {
    //查询所有出险信息
    public List<Riskmessage> selAllRiskMessage();

    //添加出险信息
    public int addRiskMessage(Riskmessage riskmessage);
}
