package com.java.service;

import com.java.pojo.Riskmessage;

import java.util.List;

public interface RiskMessageService {
    //查询所有出险信息
    public List<Riskmessage> selAllRiskMessage();
}
