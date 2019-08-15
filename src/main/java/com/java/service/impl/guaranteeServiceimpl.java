package com.java.service.impl;

import com.java.mapper.guaranteeMapper;
import com.java.pojo.Policys;
import com.java.service.guaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int tianjianfind(Policys po){
        return gm.tianjianfind(po);
    }

}
