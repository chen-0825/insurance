package com.java.service;

import com.java.pojo.Policys;

import java.util.List;

/**
 * @author zl
 * @create 2019-08-14 18:38
 */
public interface guaranteeService {

    int guaranteeinsert(Policys po);

    List<Policys> guaranteesfindAll();

    int guaranteedelete(String policyId);

    int tianjianfind(Policys po);

}
