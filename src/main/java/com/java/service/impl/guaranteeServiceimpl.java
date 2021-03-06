package com.java.service.impl;

import com.java.mapper.guaranteeMapper;
import com.java.pojo.Policys;
import com.java.service.guaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zl
 * @create 2019-08-14 18:43
 */
@Service
public class guaranteeServiceimpl implements guaranteeService {

    @Autowired
    private guaranteeMapper gm;

    public int guaranteeinsert(Policys po){
        return gm.guaranteeinsert(po);
    }

    public List<Policys> guaranteesfindAll(){
        return gm.guaranteesfindAll();
    }

    public int guaranteedelete(String policyId){
        return gm.guaranteedelete(policyId);
    }

    public List<Policys> tiaojianfind(Policys po){
//        System.out.println(po);
        return gm.tiaojianfind(po);
    }

    public int update(String policyId,String policyState){
        return gm.update(policyId,policyState);
    }

    public int updatepolicyState(String end){
        return gm.updatepolicyState(end);
    }

}
