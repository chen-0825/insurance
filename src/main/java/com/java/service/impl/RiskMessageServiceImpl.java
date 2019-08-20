package com.java.service.impl;

import com.java.mapper.RiskMessageMapper;
import com.java.pojo.Riskmessage;
import com.java.service.RiskMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RiskMessageServiceImpl implements RiskMessageService {
    @Autowired
    private RiskMessageMapper riskMessageMapper;
    public List<Riskmessage> selAllRiskMessage() {
        return riskMessageMapper.selAllRiskMessage();
    }

    @Override
    public int addRiskMessage(Riskmessage riskmessage) {
        return riskMessageMapper.addRiskMessage(riskmessage);
    }

    @Override
    public Riskmessage selAllRiskMessageBy(Riskmessage riskmessage) {
        return riskMessageMapper.selAllRiskMessageBy(riskmessage);
    }

    @Override
    public int delSomeMessage(String[] ids) {
        return riskMessageMapper.delSomeMessage(ids);
    }

    @Override
    public int delRiskMessage(Integer riskId) {
        return riskMessageMapper.delRiskMessage(riskId);
    }

    @Override
    public int updateRiskMessage(Riskmessage riskmessage) {
        return riskMessageMapper.updateRiskMessage(riskmessage);
    }
}
