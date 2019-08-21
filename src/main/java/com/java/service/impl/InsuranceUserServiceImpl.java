package com.java.service.impl;
import com.java.mapper.InsuranceUserMapper;
import com.java.pojo.InsuranceUser;
import com.java.service.InsuranceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class InsuranceUserServiceImpl implements InsuranceUserService {
    @Autowired
    private InsuranceUserMapper InsuranceuserMapper;


    //增
    public int add(InsuranceUser insuranceuser) {
        return InsuranceuserMapper.add(insuranceuser);
    }

    //删
    public int delete(InsuranceUser insuranceuser) {
        return InsuranceuserMapper.delete(insuranceuser);
    }

    //改
    public int update(InsuranceUser insuranceuser) {
        return InsuranceuserMapper.update(insuranceuser);
    }

    //查所有
    public List<InsuranceUser> findAll() {
        return InsuranceuserMapper.findAll();
    }

    //查单条
    public InsuranceUser findOne(InsuranceUser insuranceuser) {
        return InsuranceuserMapper.findOne(insuranceuser);
    }

    //多条件查询
    public List<InsuranceUser> searchOne(InsuranceUser insuranceuser) {
        return InsuranceuserMapper.searchOne(insuranceuser);
    }

    //    批量删除
    public int batchDelete(String[] iuId) {
        return InsuranceuserMapper.batchDelete(iuId);
    }

    //     分页
    public List<InsuranceUser> findOneSelf(InsuranceUser insuranceuser) {
        return InsuranceuserMapper.findOneSelf(insuranceuser);
    }

    @Override
    public InsuranceUser findOnesfz(InsuranceUser insuranceuser) {
        return InsuranceuserMapper.findOnesfz(insuranceuser);
    }
}
