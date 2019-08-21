package com.java.mapper;

import com.java.pojo.Riskmessage;

import java.util.List;

public interface RiskMessageMapper {
    //查询所有出险信息
    public List<Riskmessage> selAllRiskMessage(String riskHander);
    public Riskmessage selAllRiskMessageBy(Riskmessage riskmessage);
    //添加出险信息

    public int addRiskMessage(Riskmessage riskmessage);

    //批量删除
    public int delSomeMessage(String[] ids);

    //单个删除
    public int delRiskMessage(Integer riskId);

    //修改两个状态

    public int updateRiskMessage(Riskmessage riskmessage);

}
