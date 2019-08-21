package com.java.service;

import com.java.pojo.Policys;

import java.util.Date;
import java.util.List;

/**
 * @author zl
 * @create 2019-08-14 18:38
 */
public interface guaranteeService {

    int guaranteeinsert(Policys po);

    List<Policys> guaranteesfindAll();

    int guaranteedelete(String policyId);

    List<Policys> tiaojianfind(Policys po);

    int update(String policyId,String policyState);

    int updatepolicyState(String end);

}
