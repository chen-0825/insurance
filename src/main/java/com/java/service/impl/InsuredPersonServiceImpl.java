package com.java.service.impl;
import com.java.mapper.InsuredPersonMapper;
import com.java.pojo.InsuredPerson;
import com.java.service.InsuredPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InsuredPersonServiceImpl implements InsuredPersonService {
    @Autowired
    private InsuredPersonMapper insuredpersonMapper;


    @Override
    public int add(InsuredPerson insuredperson) {
        return insuredpersonMapper.add(insuredperson);
    }

    @Override
    public int delete(InsuredPerson insuredperson) {
        return insuredpersonMapper.delete(insuredperson);
    }

    @Override
    public int update(InsuredPerson insuredperson) {
        return insuredpersonMapper.update(insuredperson);
    }

    @Override
    public List<InsuredPerson> findAll() {
        return insuredpersonMapper.findAll();
    }

    @Override
    public InsuredPerson findOne(InsuredPerson insuredperson) {
        return insuredpersonMapper.findOne(insuredperson);
    }

    @Override
    public List<InsuredPerson> searchOne(InsuredPerson insuredperson) {
        return insuredpersonMapper.searchOne(insuredperson);
    }

    @Override
    public int batchDelete(String[] ipId) {
        return insuredpersonMapper.batchDelete(ipId);
    }

    @Override
    public List<InsuredPerson> findOneSelf(InsuredPerson insuredperson) {
        return insuredpersonMapper.findOneSelf(insuredperson);
    }
}
